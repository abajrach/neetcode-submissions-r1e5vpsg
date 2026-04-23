class ListNode {
    int key, val;
    ListNode next;

    public ListNode(int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public ListNode() {
        this(-1, -1, null);
    }
}

class MyHashMap {

    ListNode[] map;

    public MyHashMap() {
        this.map = new ListNode[1000];
        for (int i = 0; i < 1000; i++) {
            map[i] = new ListNode();    // Initialize with dummy nodes
        }    
    }
    
    // Returns the index in the map where the (k,v) lives
    int hash(int key) {
        return key % map.length;
    }

    /*
        0: (-1,-1)-> null
        1: (-1,-1)-> (1001, 343) -> (1, 890) -> null
        2: (-1,-1)-> null
        .......

        put (1, 123)
    */
    public void put(int key, int value) {
        ListNode cur = map[hash(key)];

        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next.val = value;
                return;
            }
            cur = cur.next;
        }

        cur.next = new ListNode(key, value, null);
    }
    
    // get(1)
    public int get(int key) {
        ListNode cur = map[hash(key)];
        while (cur.next != null) {
            if (cur.next.key == key) {
                return cur.next.val;
            }
            cur = cur.next;
        }

        return -1;
    }
    
    // remove(1)
        /*
        0: (-1,-1)-> null
        1: (-1,-1)-> (1001, 343) -> (1, 890) -> null
        2: (-1,-1)-> null
        .......
    */
    public void remove(int key) {
        ListNode cur = map[hash(key)];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */