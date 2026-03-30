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

    // DFS Pre-order traversal
    // Keep track of maxValue we have seen so far in the current path
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxValue) {
        if (node == null) return 0;

        int retVal = (node.val >= maxValue) ? 1 : 0;

        // Update maxValue we have seen so far in this path
        maxValue = Math.max(maxValue, node.val);
        
        retVal += dfs(node.left, maxValue);
        retVal += dfs(node.right, maxValue);

        return retVal;
    }
}
