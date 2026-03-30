class LRUCache {

    class DNode {
        int key, value;
        DNode prev, next;

        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private DNode head, tail;
    private Map<Integer, DNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head = new DNode(-1, -1);
        this.tail = new DNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        DNode node = map.get(key);
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DNode node = map.get(key);
        if(node != null) {
            node.value = value;
            moveToFront(node);
        } else {
            node = new DNode(key, value);
            if (map.size() >= capacity) {
                popTailOut();
            }
            addToFront(node);
            map.put(key, node);
        }
        // DNode node = null;
        // if (map.containsKey(key)) {
        //     node = map.get(key);
        //     node.value = value;
        //     moveToFront(node);
        // } else {
        //     node = new DNode(key, value);
        //     if (map.size() >= capacity) {
        //         popTailOut();
        //     }
        //     addToFront(node);
        //     map.put(key, node);
        // }
    }

    private void moveToFront(DNode node) {
        removeNode(node);
        addToFront(node);
    }

    // head -> 1 -> 2 -> 3 -> tail
    private void removeNode(DNode node) {
        DNode savedPrev = node.prev;
        DNode savedNext = node.next;

        savedPrev.next = savedNext;
        savedNext.prev = savedPrev;
    }

    // head -> 2 -> 3 -> tail
    private void addToFront(DNode node) {
        DNode curFront = head.next;
        head.next = node;
        node.prev = head;
        node.next = curFront;
        curFront.prev = node;
    }

    // head -> 1 -> 2 -> 3 -> tail
    private void popTailOut() {
        map.remove(tail.prev.key);
        DNode newLastNode = tail.prev.prev;
        newLastNode.next = tail;
        tail.prev = newLastNode;
    }
}
