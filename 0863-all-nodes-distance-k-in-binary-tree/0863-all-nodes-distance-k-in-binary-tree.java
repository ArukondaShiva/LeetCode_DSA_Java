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
    
    public void markParents(TreeNode root,Map<TreeNode,TreeNode> parent_track,TreeNode target){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left!=null){
                parent_track.put(current.left,current);
                queue.offer(current.left);
            }
            if(current.right!=null){
                parent_track.put(current.right,current);
                queue.offer(current.right);
            }
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      Map<TreeNode,TreeNode> parent_track = new HashMap<>();
      markParents(root,parent_track,target);
        
      Map<TreeNode,Boolean> visited = new HashMap<>();
      Queue<TreeNode> queue = new LinkedList<>();
        
      queue.offer(target);
      visited.put(target,true);
      int cur_level=0;
        
      while(!queue.isEmpty()){
          
          int size=queue.size();
          if(cur_level==k){
              break;
          }
          
          for(int i=0;i<size;i++){
              
              TreeNode current = queue.poll();
              if(current.left!=null && visited.get(current.left)==null){
                  queue.offer(current.left);
                  visited.put(current.left,true);
              }
              if(current.right!=null && visited.get(current.right)==null){
                  queue.offer(current.right);
                  visited.put(current.right,true);
              }
              if(parent_track.get(current)!=null && visited.get(parent_track.get(current))==null){
                  queue.offer(parent_track.get(current));
                  visited.put(parent_track.get(current),true);
              }
          }
          
          cur_level++;
          
      }
        
        List<Integer> result = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode current=queue.poll();
            result.add(current.val);
        }
        
        return result;
    }
    
    
    
    
    
}