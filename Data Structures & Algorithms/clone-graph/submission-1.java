/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    // BFS
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for (Node nei: cur.neighbors) {
                if (!oldToNew.containsKey(nei)) {
                    oldToNew.put(nei, new Node(nei.val));
                    q.offer(nei);
                }
                oldToNew.get(cur).neighbors.add(oldToNew.get(nei));
            }
        }

        return copy;
    }
}