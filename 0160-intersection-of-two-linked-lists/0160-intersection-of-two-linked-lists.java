/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;
        
        while(d1!=d2){
            
            if(d1==null){
                d1 = headB;
            }else{
                d1 = d1.next;
            }
            
            if(d2==null){
                d2 = headA;
            }else{
                d2 = d2.next;
            }
            
        }
        
        return d1;
        
    }
}