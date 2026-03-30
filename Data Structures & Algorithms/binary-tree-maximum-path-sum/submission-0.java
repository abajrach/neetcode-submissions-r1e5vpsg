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
    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxValue;     
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);

        maxValue = Math.max(maxValue, node.val + leftMax + rightMax);

        return Math.max(0, node.val + Math.max(leftMax, rightMax));
    }
}
