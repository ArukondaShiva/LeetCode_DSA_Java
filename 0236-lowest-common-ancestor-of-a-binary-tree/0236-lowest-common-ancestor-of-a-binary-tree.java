/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return findLCA(root, p, q);
    }

    public TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        
        if (node == null || node == p || node == q) {
            return node;
        }

        TreeNode left = findLCA(node.left, p, q);
        TreeNode right = findLCA(node.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return node;
        }
        
    }
}
