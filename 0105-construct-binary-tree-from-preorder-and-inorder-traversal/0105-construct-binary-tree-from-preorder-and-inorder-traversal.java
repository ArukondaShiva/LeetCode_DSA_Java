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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       
        HashMap<Integer,Integer> inMap = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }  
        
        TreeNode root = buildTreeFun(preorder,0,preorder.length-1, inorder, 0, inorder.length-1,inMap);
        return root;
    }
    
    public TreeNode buildTreeFun(int preorder[],int preStart,int preEnd,int inorder[],int inStart,int inEnd,HashMap<Integer,Integer> inMap){
        
      
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        
        root.left = buildTreeFun(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,inMap);
        root.right = buildTreeFun(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,inMap);
        
        return root;
    }
    
}














