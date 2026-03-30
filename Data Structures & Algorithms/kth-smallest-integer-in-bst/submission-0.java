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

    // Recursive solution
    // Inorder traversal of BST gives values in sorted list
    // Return k-1th item from that sorted list
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sorted = new ArrayList<>();
        dfs(root, sorted);
        return sorted.get(k - 1);
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) return;

        dfs(node.left, result);
        result.add(node.val);
        dfs(node.right, result);
    }
}
