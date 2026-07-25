class LRUCache {
    Map<Integer, Node> map;
    int capacity;

    CDLL cdll;

    public LRUCache(int capacity) {
        cdll = new CDLL();

        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        return cdll.moveBegin(map.get(key));
    }
    
    public void put(int key, int value) {
        Node node;

        if(map.containsKey(key)){
            node = map.get(key);
            node.val = value;

            cdll.moveBegin(node);
        }
        else{
            node = new Node(key, value);
            
            if(map.size() == capacity){
                Node removed = cdll.removeLast();
                map.remove(removed.key);
            }
            
            cdll.addNode(node);
            map.put(key, node);
        }
    }
}

class CDLL{
    Node head;
    Map<Integer, Node> map;

    int moveBegin(Node node){
        if(node == head)
            return node.val;;
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;

        head = node;

        return node.val;
    }

    Node removeLast(){
        Node rem = head;

        if(head.prev == head){
            head = null;
            return rem;
        }

        rem = head.prev;

        head.prev.prev.next = head;
        head.prev = head.prev.prev;

        return rem;
    }

    void addNode(Node node){
        if(head == null){
            head = node;
            head.prev = head;
            head.next = head;
            return;
        }

        head.prev.next = node;
        node.prev = head.prev;

        head.prev = node;
        node.next = head;

        head = node;
    }

}

class Node{
    int key, val;
    Node prev, next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */