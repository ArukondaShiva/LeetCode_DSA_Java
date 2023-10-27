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

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return makeBST(nums, 0, n - 1);
    }

    public TreeNode makeBST(int nums[], int low, int high) {
        
        if(low>high){
            return null;
        }
        
        if(low==high){
            return new TreeNode(nums[low]);
        }

        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = makeBST(nums, low, mid-1);
        root.right = makeBST(nums, mid+1, high);

        return root;
    }
    
}
