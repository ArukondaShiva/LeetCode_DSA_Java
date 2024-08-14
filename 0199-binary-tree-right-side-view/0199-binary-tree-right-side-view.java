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
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        findRightSide(root,0,ans);
        return ans;
    }
    
    public void findRightSide(TreeNode node,int level,List<Integer> ans){
        
        if(node==null){
            return;
        }
        
        if(level == ans.size()){
            ans.add(node.val);
        }
        
        findRightSide(node.right, level+1, ans);
        findRightSide(node.left, level+1, ans);
    }
    
}




