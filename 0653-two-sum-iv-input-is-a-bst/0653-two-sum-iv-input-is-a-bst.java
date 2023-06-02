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
 


class BSTiterator{

    private Stack<TreeNode> stack = new Stack<TreeNode>();

    boolean isReverse = true;
    //boolean == true--> before
    //boolean == false -->next

    public BSTiterator(TreeNode root,boolean _isReverse){
        isReverse = _isReverse;
        pushAll(root);
    }

    public int next(){
        TreeNode temp = stack.pop();
        if(isReverse==true){
            pushAll(temp.left);
        }else{
            pushAll(temp.right);
        }
        return temp.val;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public void pushAll(TreeNode root){
       while(root!=null){
             stack.push(root);
           if(isReverse==true){
               root = root.right;
           }else{
               root = root.left;
           }
       }
    }    

}

class Solution {
    public boolean findTarget(TreeNode root, int k) {

        BSTiterator l = new BSTiterator(root,false);
        BSTiterator r = new BSTiterator(root,true);

        int i = l.next();
        int j = r.next();

        while(i<j){
            if(i+j==k){
                return true;
            }else if(i+j<k){
                i = l.next();
            }else{
                j = r.next();
            }
        }
        return false;
    }
}













