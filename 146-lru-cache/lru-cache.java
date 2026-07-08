class LRUCache {

    class Node{
        Node next;
        Node prev;
        int key;
        int val;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    int capacity = 0;
    HashMap<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {

        map = new HashMap<>();

        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node curr = null;

        if(map.containsKey(key)){
            curr = map.get(key);
            update(curr, false);
        }

        return curr == null ? -1 : curr.val;
    }
    
    public void put(int key, int value) {
        Node curr;

        if(map.containsKey(key)){
            curr = map.get(key);
            curr.val = value;

            update(curr, false);
        }
        else{
            curr = new Node(key, value);
            map.put(key, curr);

            if(map.size() > capacity){
                map.remove(head.key);

                if(capacity == 1){
                    head = null;
                    tail = null;
                }
                else{
                    head = head.next;
                    head.prev = null;
                }
            }

            update(curr, true);
        }
    }

    private void update(Node curr, boolean isNew){
        if(isNew){
            if(tail == null){
                head = curr;
                tail = curr;
            }
            else{
                tail.next = curr;
                curr.prev = tail;

                tail = curr;
            }
        }
        else{
            if(head == null){
                head = curr;
                tail = curr;
            }
            if(curr == tail){
                return;
            }
            if(curr == head){
                head = curr.next;
                head.prev = null;
            }
            else{
                curr.prev.next = curr.next;
            }
            
            curr.next.prev = curr.prev;
            curr.next = null;

            tail.next = curr;
            curr.prev = tail;
            tail = curr;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */