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

    public boolean isBalanced(TreeNode root) {
        int check = checkBalanced(root);
        return check == -1 ? false : true;
    }

    public int checkBalanced(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lh = checkBalanced(node.left);
        if (lh == -1) {
            return -1;
        }

        int rh = checkBalanced(node.right);
        if (rh == -1) {
            return -1;
        }

        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }
}
