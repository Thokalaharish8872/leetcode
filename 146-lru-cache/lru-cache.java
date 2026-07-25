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

        // fresh cache memory
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {

        // if data is not present then return -1;
        if(!map.containsKey(key)) return -1;

        // update LRU
        Node curr = map.get(key);
        update(curr, false);

        return curr.val;
    }
    
    public void put(int key, int value) {
        Node curr;

        // update the val of key if present and also update LRU
        if(map.containsKey(key)){
            curr = map.get(key);
            curr.val = value;

            update(curr, false);
        }

        // if not present add new node in map and also update LRU
        else{
            curr = new Node(key, value);

            // before adding into LRU check if capacity of the LRU reached
            if(map.size() == capacity){
                map.remove(head.key);

                // if capacity is 1 make everything null, in this way we will overcome null pointer exception
                if(capacity == 1){
                    head = null;
                    tail = null;
                }

                // if capacity is not 1 we can perform normal operation i.e remove least recently used data and by removing head
                else{
                    head = head.next;
                    head.prev = null;
                }
            }

            // add new data to the LRU and update
            map.put(key, curr);
            update(curr, true);
        }
    }

    private void update(Node curr, boolean isNew){

        // irrespective of new data or update data we make the curr node as head and tail
        if(head == null && tail == null){
            head = curr;
            tail = curr;
            return;
        }


        // perform's this logic if the data is newly added
        if(isNew){

            tail.next = curr;
            curr.prev = tail;

            tail = curr;
        }

        // performs' this logic if the data needs update instead of adding new data
        else{
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