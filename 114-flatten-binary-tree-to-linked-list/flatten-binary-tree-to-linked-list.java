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
    public void flatten(TreeNode root) {
        helper(root);
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left, right = root.right;
        helper(left);
        helper(right);

        if (left != null && right != null) {
            root.right = left;
            root.left = null;
            TreeNode curr = left;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = right;
        } else if (right == null) {
            root.right = left;
            root.left = null;
        }
    }
}