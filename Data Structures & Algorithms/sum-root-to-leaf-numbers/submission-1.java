/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            int num = pair.getValue();
            num = num * 10 + node.val;

            if (node.left == null && node.right == null) {
                sum += num;
                continue;
            }

            if (node.left != null) {
                q.offer(new Pair<>(node.left, num));
            }

            if (node.right != null) {
                q.offer(new Pair<>(node.right, num));
            }
        }
        return sum;
    }
}