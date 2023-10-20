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
    
    public ListNode partition(ListNode head, int x) {
    
        ListNode smallList = new ListNode();
        ListNode LargeList = new ListNode();
        
        ListNode dNode1 = smallList;
        ListNode dNode2 = LargeList;
        
        while(head!=null){
            if(head.val<x){
                smallList.next = head;
                smallList = smallList.next;
            }
            else{
                LargeList.next = head;
                LargeList = LargeList.next;
            }
            head = head.next;
        }
        
        LargeList.next = null;
        smallList.next = dNode2.next;
        
        
        return dNode1.next;
    }
    
}