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
    
    public ListNode removeZeroSumSublists(ListNode head) {
    
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        HashMap<Integer,ListNode> map = new HashMap<>();
        map.put(0,dummy);
        
        ListNode cur = head;
        int sum = 0;
        
        while(cur!=null){
            
            sum = sum+cur.val;
            
            if(map.containsKey(sum)){
                ListNode temp = map.get(sum);
                ListNode temp2 = temp.next;
                int tempsum = sum;
                
                while(temp2!=cur){
                    tempsum += temp2.val;
                    if(map.containsKey(tempsum)){
                        map.remove(tempsum);
                    }
                    temp2 = temp2.next;
                }
                
                temp.next = cur.next;
            }
            else{
                map.put(sum,cur);    
            }
            
            cur = cur.next;
        }
         
        return dummy.next;
    }
    
}