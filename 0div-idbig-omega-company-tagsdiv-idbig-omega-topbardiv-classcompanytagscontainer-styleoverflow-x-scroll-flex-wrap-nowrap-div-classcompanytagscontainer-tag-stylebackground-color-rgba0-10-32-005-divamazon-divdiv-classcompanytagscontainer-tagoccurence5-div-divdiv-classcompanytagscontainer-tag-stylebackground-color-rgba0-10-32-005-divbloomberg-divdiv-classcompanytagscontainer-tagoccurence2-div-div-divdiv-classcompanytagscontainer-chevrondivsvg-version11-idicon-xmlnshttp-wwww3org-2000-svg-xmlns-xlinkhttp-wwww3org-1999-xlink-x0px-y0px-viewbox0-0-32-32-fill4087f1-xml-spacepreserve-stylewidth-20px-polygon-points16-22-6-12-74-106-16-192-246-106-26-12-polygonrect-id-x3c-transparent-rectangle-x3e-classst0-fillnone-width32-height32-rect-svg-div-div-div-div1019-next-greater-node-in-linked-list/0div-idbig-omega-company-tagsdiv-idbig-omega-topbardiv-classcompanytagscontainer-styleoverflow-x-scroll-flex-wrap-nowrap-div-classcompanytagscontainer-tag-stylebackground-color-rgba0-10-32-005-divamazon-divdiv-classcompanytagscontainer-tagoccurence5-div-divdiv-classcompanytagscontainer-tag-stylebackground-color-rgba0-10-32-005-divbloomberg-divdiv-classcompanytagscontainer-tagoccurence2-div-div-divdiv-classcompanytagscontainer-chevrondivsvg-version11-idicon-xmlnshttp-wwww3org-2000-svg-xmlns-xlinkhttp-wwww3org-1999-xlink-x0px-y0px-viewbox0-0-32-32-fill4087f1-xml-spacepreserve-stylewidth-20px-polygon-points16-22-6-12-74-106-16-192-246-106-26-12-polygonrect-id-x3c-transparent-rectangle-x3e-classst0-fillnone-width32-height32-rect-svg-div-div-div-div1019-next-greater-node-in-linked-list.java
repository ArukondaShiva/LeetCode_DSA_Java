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
    
    public int[] nextLargerNodes(ListNode head) {
    
        int length = 0;
        ListNode cur = head;
        
        List<Integer> list = new ArrayList<>();
        
        while(cur!=null){
            length++;
            list.add(cur.val);
            cur = cur.next;
        }
        
        Stack<Integer> st = new Stack<>();
        int result[] = new int[length];
        
        for(int i=length-1;i>=0;i--){
            while(!st.isEmpty() && list.get(i)>=st.peek()){
                st.pop();
            }
            result[i] = st.isEmpty() ? 0 : st.peek();
            st.push(list.get(i));
        }
        
        return result;
    }
    
}