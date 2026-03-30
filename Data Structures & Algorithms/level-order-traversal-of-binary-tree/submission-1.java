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
    // DFS solution using recursion
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;

        // If we are at this level for the first time, it means the 
        // list at that level hasn't been initialized yet.
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
