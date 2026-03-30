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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long left, long right) {
        if(node == null) return true;

        // Check if current node's value is in between left and right boundary
        if (!(node.val > left && node.val < right))
            return false;

        // For left sub-tree, the upper bound is current node's value
        // For right sub-tree, the lower bound is the current node's value
        return dfs(node.left, left, node.val) &&
                dfs(node.right, node.val, right);
    }
}
