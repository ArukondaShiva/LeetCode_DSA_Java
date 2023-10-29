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
    
    public ListNode insertionSortList(ListNode head) {
        
        if(head==null || head.next==null){
            return head;
        }
    
        ListNode dummy = new ListNode(-6000);
        
        ListNode prev = dummy;
        ListNode cur = head;
        
        while(cur!=null){
            ListNode next = cur.next;
            
            if(prev.val>cur.val){
                prev = dummy;
            }
            
            while(prev.next!=null && prev.next.val<cur.val){
                prev = prev.next;
            }
            
            cur.next = prev.next;
            prev.next = cur;
            
            cur = next;
        }
        
        return dummy.next;
    }
    
}