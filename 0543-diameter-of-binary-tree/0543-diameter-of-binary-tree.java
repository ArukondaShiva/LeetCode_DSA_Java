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
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];
        diameter[0] = 0;
        
        findDiameter(root,diameter);
        
        return diameter[0];
    }
    
    public int findDiameter(TreeNode cur, int diameter[]){
        
        if(cur==null){
            return 0;
        }
        
        int lh = findDiameter(cur.left , diameter);
        
        int rh = findDiameter(cur.right , diameter);
        
        diameter[0] = Math.max(diameter[0],lh+rh);
        
        return 1+Math.max(lh,rh);
        
    }
    
    
}