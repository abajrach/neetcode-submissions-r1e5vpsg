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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // otherwise it will throw NPE in next line
        if (root == null || p == null || q == null) return null;

        // If bigger value is smaller than me, check left sub-tree
        if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // if smaller value is bigger than me, check right sub-tree 
        else if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
