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
    
    public int rob(TreeNode root) {
        int result[] =  maxRob(root); 
        return Math.max(result[0],result[1]);
    }
    
    public int[] maxRob(TreeNode root){
        
        // in array[] --> 0th index ==> included value
        // 1st index ==> excluded value
        
        if(root==null){
            return new int[]{0,0};
        }
        
        int left[] = maxRob(root.left);
        int right[] = maxRob(root.right);
        
        int result[] = new int[2];
        
        // root include --> childrens exclude
        result[0] = root.val+left[1]+right[1];
        
        // root exclude --> childrens include
        result[1] =  Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        
        return  result;
    }
    
}










