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

    Map<TreeNode, Integer> cache;

    // Regular DFS using HashMap for Memoization
    public int rob(TreeNode root) {
        cache = new HashMap<>();
        cache.put(null, 0);
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if(cache.containsKey(node)) {
            return cache.get(node); // Also works for null nodes (returns 0)
        }

        int res = node.val;

        if (node.left != null) {
            res += dfs(node.left.left) + dfs(node.left.right);
        }

        if (node.right != null) {
            res += dfs(node.right.left) + dfs(node.right.right);
        }

        res = Math.max(res, dfs(node.left) + dfs(node.right));
        cache.put(node, res);

        return res;

    }
}