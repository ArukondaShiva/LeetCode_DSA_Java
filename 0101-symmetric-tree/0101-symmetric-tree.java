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
    
    public boolean isSymmetric(TreeNode root) {
        return checkIsSymmetric(root.left, root.right);
    }
    
    public boolean checkIsSymmetric(TreeNode p, TreeNode q){
        
        if(p==null || q==null){
            return p==q;
        }
        
        if(p.val != q.val){
            return false;
        }
        
        return (p.val == q.val) && checkIsSymmetric(p.left, q.right) && checkIsSymmetric(p.right, q.left);
        
    }
    
}