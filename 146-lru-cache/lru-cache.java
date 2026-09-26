class LRUCache {
    List<Node> list;
    Map<Integer, Node> map;

    CCDL ccdl;

    public LRUCache(int capacity) {
        list = new LinkedList<>();
        map = new HashMap<>();

        ccdl = new CCDL(map, capacity);
    }
    
    public int get(int key) {
        if(map.containsKey(key))
            return ccdl.moveFirst(map.get(key));
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node address = map.get(key);
            address.val = value;

            ccdl.moveFirst(address);
        }
        else
            ccdl.addNode(key, value);
    }
}

class CCDL{
    Map<Integer, Node> map;
    int capacity;

    Node head, tail;

    public CCDL(Map<Integer, Node> map, int capacity){
        this.map = map;
        this.capacity = capacity;
    }

    public int moveFirst(Node address){
        if(address != tail){
            if(address == head)
                head = head.next;
            else
                address.prev.next = address.next;
            address.next.prev = address.prev;

            tail.next = address;
            address.prev = tail;
            address.next = null;

            tail = address;
        }

        return address.val;
    }

    public void addNode(int key, int val){
        Node newNode = new Node(key, val);
        map.put(key, newNode);

        if(head == null)
            head = tail = newNode;
        else{
            tail.next = newNode;
            newNode.prev = tail;

            tail = newNode;

            if(map.size() > capacity){
                map.remove(head.key);
                head = head.next;
            }
        }
    }
}

class Node{
    Node next, prev;
    int key, val;

    public Node(int key, int val){
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