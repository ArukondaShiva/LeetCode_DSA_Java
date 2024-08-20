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
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    
        List<TreeNode> ansList = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        
        findDuplicates(root,ansList,map);
        return ansList;
    }
    
    public String findDuplicates(TreeNode node,List<TreeNode> ansList,Map<String,Integer> map){
        
        if(node==null){
            return "$";
        }
        
        String leftStr = findDuplicates(node.left,ansList,map);
        String rightStr = findDuplicates(node.right, ansList,map);
        
        String subStr = leftStr+","+rightStr+","+String.valueOf(node.val);
        
        if(map.containsKey(subStr) && map.get(subStr)==1){
            ansList.add(node);
        }
        
        map.put(subStr,map.getOrDefault(subStr,0)+1);
        
        return subStr;
    }
    
    
}







