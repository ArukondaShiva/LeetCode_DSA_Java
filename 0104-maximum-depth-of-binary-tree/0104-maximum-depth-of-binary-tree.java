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

    public int maxDepth(TreeNode root) {
        int diameter[] = new int[1];
        findHeight(root, diameter);
        return diameter[0];
    }

    public int findHeight(TreeNode cur, int diameter[]) {
        if (cur == null) {
            return 0;
        }
        int lh = findHeight(cur.left, diameter);
        int rh = findHeight(cur.right, diameter);
        diameter[0] = Math.max(diameter[0], Math.max(lh, rh) + 1);
        return 1 + Math.max(lh, rh);
    }
    
}
