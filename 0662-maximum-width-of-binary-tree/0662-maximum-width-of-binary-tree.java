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

class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode _node,int _num){
        node = _node;
        num = _num;
    }
}

class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {
     
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        
        int maxWidth = 0;
        
        while(!q.isEmpty()){
            
            int min_num = q.peek().num;
            
            int size = q.size();
            
            int first = 0;
            int last = 0;
            
            for(int i=0;i<size;i++){
                
                int cur_min = q.peek().num-min_num;
                TreeNode node = q.peek().node;
                q.remove();
                
                if(i==0){
                    first = cur_min;
                }
                if(i==size-1){
                    last = cur_min;
                }
                
                if(node.left!=null){
                    q.add(new Pair(node.left,(2*cur_min+1)));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right,(2*cur_min+2)));
                }
                
                maxWidth = Math.max(maxWidth,last-first+1);
            }
            
        }
        
        return maxWidth;
    }
    
}