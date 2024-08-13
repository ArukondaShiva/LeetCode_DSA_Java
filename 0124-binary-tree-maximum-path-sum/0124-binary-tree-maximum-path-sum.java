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
    
    public int maxPathSum(TreeNode root) {
        
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        
        findMaxSum(root,maxSum);
        return maxSum[0];
    }
    
    public int findMaxSum(TreeNode node,int maxSum[]){
        
        if(node==null){
            return 0;
        }
        
        int leftH = Math.max( 0, findMaxSum(node.left, maxSum));
        int rightH = Math.max(0, findMaxSum(node.right, maxSum));
        
        maxSum[0] = Math.max(maxSum[0], node.val + (leftH + rightH));
        
        return node.val + Math.max(leftH, rightH);
        
    }
    
}















