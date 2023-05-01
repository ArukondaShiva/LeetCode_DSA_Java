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

class Tuple {
    TreeNode node;
    int row;
    int col;

    Tuple(TreeNode _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();

            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;

            if (!map.containsKey(row)) {
                map.put(row, new TreeMap<>());
            }

            if (!map.get(row).containsKey(col)) {
                map.get(row).put(col, new PriorityQueue<Integer>());
            }

            map.get(row).get(col).offer(node.val);

            if (node.left != null) {
                q.add(new Tuple(node.left, row - 1, col + 1));
            }

            if (node.right != null) {
                q.add(new Tuple(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> finalList = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> subList = new ArrayList<>();

            finalList.add(new ArrayList<>());

            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty()) {
                    finalList.get(finalList.size() - 1).add(pq.peek());
                    pq.poll();
                }
            }
        }

        return finalList;
    }
}
