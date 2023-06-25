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
    
    ListNode head = null;
    
    public ListNode reverseList(ListNode head) {
    
        if(head==null || head.next==null){
            return head;
        }
        
        return reverse_Recursion(head);
    }
    
    public ListNode reverse_Recursion(ListNode cur){
        
        if(cur.next==null){
            head = cur;
            return cur;
        }
        
        reverse_Recursion(cur.next);
        ListNode next = cur.next;
        next.next = cur;
        cur.next = null;
        return head;
    }
    
    
}