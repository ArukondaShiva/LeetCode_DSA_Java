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
    
    public List<Integer> postorderTraversal(TreeNode root) {
    
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        
        TreeNode cur = root;
        
        while(cur!=null || !st.isEmpty()){
            
            if(cur!=null){
                st.add(cur);
                cur = cur.left;
            }
            else{
                TreeNode temp = st.peek().right;
                
                if(temp == null){
                    temp = st.pop();
                    ans.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                   
                }
                else{
                    cur = temp;
                }
            }
            
        }
        
        return ans;
    }
    
}


