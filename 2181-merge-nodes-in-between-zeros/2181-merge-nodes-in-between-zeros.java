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
    public ListNode mergeNodes(ListNode head) {
        
        if(head==null){
            return head;
        }
        
        ListNode cur = head.next;
        ListNode prev = head;
        int sum = 0;
        
        while(cur!=null){
            
            if(cur.val==0){
                cur.val = sum;
                prev.next = cur;
                cur = cur.next;
                prev = prev.next;
                sum = 0;
            }
            else{
                sum += cur.val;
                cur = cur.next;
            }
        }
        
        return head.next;
    }
}