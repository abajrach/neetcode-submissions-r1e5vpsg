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
    // Global variable to keep track of max value so far.
    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxValue;     
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);

        // Calculate and update maxValue up to this node.
        // maxValue includes the sum of current node + leftMax + rightMax
        maxValue = Math.max(maxValue, node.val + leftMax + rightMax);

        // Return the maximum value if we were to pick either left or right sub-tree
        // Hence we are doing Math.max(leftMax, rightMax)
        // Edge case: if the node.val is negative, we don't want to include that. Hence,
        // we do Math.max(0, ...). Neat trick.
        return Math.max(0, node.val + Math.max(leftMax, rightMax));
    }
}
