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
    
    public ListNode sortList(ListNode head) {
        
        if(head==null || head.next==null){
            return head;
        }  
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode temp = slow.next;
        slow.next = null;
        
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(temp);
        
        return mergeTwoLists(list1,list2);
    }
    
    
    
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
       if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        
        if(list1.val>list2.val){
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        
        ListNode res = list1;
        ListNode temp1 = list1;
        
        while(list1!=null && list2!=null){
            
            while(list1!=null && list1.val<=list2.val){
                temp1 = list1;
                list1 = list1.next;
            }
            temp1.next = list2;
            
            ListNode temp2 = list1;
            list1 = list2;
            list2 = temp2;
        }
        
        return res;
    }
}

