/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode swapPairs(ListNode head) {
        return recursion(head, head == null ? head : head.next);
    }

    public ListNode recursion(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a;
        }

        ListNode temp = b.next;
        b.next = a;
        a.next = recursion(temp, temp == null ? temp : temp.next);
        return b;
    }
}
