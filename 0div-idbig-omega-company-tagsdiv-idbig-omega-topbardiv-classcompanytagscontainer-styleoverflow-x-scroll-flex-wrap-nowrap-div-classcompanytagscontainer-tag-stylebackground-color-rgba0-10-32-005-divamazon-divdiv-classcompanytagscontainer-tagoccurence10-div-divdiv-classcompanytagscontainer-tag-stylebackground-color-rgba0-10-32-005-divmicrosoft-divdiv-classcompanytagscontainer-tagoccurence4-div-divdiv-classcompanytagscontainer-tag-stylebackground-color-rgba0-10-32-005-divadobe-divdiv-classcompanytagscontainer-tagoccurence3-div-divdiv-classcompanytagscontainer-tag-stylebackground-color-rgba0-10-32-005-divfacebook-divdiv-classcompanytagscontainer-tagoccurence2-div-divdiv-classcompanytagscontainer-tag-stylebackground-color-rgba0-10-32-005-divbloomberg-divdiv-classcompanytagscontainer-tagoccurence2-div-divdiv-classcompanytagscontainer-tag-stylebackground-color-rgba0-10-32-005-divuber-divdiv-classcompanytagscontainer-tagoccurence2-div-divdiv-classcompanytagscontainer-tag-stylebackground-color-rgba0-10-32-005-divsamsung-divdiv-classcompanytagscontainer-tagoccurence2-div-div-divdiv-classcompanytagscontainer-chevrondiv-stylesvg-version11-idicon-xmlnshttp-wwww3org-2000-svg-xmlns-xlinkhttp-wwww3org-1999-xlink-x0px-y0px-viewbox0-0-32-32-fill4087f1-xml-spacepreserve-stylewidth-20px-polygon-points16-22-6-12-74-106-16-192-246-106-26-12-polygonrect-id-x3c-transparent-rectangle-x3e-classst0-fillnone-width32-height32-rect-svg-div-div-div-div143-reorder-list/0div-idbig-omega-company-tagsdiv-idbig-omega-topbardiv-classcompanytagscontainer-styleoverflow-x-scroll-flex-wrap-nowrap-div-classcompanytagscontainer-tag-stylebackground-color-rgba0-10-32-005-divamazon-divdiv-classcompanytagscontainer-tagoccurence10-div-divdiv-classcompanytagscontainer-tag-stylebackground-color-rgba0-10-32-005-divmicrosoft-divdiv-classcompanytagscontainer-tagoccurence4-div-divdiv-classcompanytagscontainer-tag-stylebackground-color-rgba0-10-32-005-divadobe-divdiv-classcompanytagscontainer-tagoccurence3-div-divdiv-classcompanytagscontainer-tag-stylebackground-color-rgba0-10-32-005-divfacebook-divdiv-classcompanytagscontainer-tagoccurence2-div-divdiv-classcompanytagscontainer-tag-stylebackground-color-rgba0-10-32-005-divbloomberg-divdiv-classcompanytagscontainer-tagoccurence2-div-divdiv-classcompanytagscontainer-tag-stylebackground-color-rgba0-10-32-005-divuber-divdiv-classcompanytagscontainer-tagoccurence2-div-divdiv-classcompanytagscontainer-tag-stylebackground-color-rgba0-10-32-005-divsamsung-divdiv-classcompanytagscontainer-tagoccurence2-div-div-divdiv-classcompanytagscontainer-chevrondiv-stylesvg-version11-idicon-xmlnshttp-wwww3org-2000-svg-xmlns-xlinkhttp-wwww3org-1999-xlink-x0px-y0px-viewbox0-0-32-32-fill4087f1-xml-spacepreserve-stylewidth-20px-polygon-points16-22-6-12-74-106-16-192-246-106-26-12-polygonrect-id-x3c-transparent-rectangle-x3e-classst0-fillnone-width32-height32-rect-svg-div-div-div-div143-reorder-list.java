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
    
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null){
            return;
        }
        
        ListNode midNode = findMidNode(head);
        ListNode head2 = reverseLL(midNode.next);
        midNode.next = null;
        
        ListNode head1 = head;
        while(head1!=null && head2!=null){
            ListNode h1next = head1.next;
            ListNode h2next = head2.next;
            head1.next = head2;
            head2.next = h1next;
            head1 = h1next;
            head2 = h2next;
        }
        
    }
    
    public ListNode findMidNode(ListNode head){
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.next;
    }
    
    public ListNode reverseLL(ListNode head){
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
}




