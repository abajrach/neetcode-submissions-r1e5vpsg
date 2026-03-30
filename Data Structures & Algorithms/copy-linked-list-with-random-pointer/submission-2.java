/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>(); // Map where origNode -> copyNode

        // Generate map containing origNode -> copyNode as key-value pairs
        // Don't link the nodes yet
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;
        }

        // Link the pointers in the copy LL referencing the original LL
        cur = head;
        while (cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head); // Return the head of the copy LL
    }
}
