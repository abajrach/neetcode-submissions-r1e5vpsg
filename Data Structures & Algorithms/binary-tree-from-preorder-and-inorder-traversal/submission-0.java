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

    // Not so efficient method
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int midIndex = -1;

        // Find the index of root in "inorder". 
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                midIndex = i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, midIndex + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, midIndex);

        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, midIndex + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, midIndex + 1, preorder.length);

        root.right = buildTree(rightPreorder, rightInorder);


        return root;
    }
}
