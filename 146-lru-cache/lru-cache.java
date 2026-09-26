class LRUCache {
    List<Node> list;
    Map<Integer, Node> map;
    
    CCDL ccdl;

    public LRUCache(int capacity) {
        list = new ArrayList<>();
        map = new HashMap<>();

        ccdl = new CCDL(capacity, map);
    }
    
    public int get(int key) {
        if(map.containsKey(key))
            return ccdl.moveFirst(map.get(key));
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
            ccdl.updateValueInList(map.get(key), value);
        else
            map.put(key, ccdl.addNewNode(key, value));
    }
}

class CCDL{
    Node head, tail;
    int size, capacity;
    Map<Integer, Node> map;

    public CCDL(int capacity, Map<Integer, Node> map){
        size = 0;
        this.capacity = capacity;
        this.map = map;
    }

    Node addNewNode(int key, int value){
        Node newNode = new Node(key, value);
        size++;

        if(head == null){
            head = tail = newNode;
        }
        else{

            tail.next = newNode;
            newNode.prev = tail;

            tail = newNode;

            if(size > capacity){
                map.remove(head.key);

                head = head.next;
                head.prev = null;

                size--;
            }
        }

        return newNode;
    }
    void updateValueInList(Node address, int value){
        address.value = value;
        moveFirst(address);
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

        return address.value;
    }
}

class Node{
    Node prev, next;
    int key, value;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */