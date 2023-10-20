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
    
    public int pairSum(ListNode head) {
    
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        
        while(temp!=null){
            st.push(temp.val);
            temp = temp.next;
        }
        
        int size = st.size();
        ListNode dummy = head;
        
        int max = 0;
        while(st.size()>size/2){
            max = Math.max(max,dummy.val+st.pop());
            dummy = dummy.next;
        }
        
        return max;
    }
    
}