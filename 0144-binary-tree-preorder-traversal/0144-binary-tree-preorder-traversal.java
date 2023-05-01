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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findPreorder(root, list);
        return list;
    }

    public void findPreorder(TreeNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        }

        list.add(cur.val);
        findPreorder(cur.left, list);
        findPreorder(cur.right, list);
    }
}
