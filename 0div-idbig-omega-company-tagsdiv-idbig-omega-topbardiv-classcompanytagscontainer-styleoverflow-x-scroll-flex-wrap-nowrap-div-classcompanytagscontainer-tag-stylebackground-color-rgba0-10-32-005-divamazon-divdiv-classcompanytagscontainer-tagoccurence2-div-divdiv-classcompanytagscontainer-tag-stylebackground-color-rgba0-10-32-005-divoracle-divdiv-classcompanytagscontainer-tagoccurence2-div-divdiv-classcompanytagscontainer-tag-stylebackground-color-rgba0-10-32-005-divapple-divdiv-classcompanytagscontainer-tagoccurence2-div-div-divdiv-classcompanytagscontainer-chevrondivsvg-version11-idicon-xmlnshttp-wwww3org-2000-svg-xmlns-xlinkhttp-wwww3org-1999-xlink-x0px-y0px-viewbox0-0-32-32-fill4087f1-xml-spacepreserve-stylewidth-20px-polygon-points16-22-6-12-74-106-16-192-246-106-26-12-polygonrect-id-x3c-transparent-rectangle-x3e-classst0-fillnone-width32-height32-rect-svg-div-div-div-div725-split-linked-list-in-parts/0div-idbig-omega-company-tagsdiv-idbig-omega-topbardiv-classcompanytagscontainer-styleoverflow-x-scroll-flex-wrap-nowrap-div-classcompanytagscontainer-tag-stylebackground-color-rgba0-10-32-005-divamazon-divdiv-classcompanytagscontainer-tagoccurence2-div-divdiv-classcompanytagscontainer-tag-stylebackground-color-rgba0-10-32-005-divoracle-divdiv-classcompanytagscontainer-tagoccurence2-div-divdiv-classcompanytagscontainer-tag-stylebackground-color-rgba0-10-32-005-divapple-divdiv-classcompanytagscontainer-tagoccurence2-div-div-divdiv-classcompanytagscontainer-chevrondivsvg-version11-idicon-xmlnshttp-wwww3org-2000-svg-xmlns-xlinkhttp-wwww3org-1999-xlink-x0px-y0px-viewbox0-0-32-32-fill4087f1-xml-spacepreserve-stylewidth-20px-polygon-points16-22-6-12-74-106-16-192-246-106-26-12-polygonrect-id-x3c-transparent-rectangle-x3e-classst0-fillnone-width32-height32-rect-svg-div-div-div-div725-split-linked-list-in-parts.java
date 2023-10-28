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
    
    public ListNode[] splitListToParts(ListNode head, int k) {
    
        int length = 0;
        ListNode temp = head;
        
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        
        int partSize = length/k;
        int extraParts = length%k;
        
        ListNode result[] = new ListNode[k];
        
        if(head==null){
            return result;
        }
        
        ListNode cur = head;
        ListNode prev = null;
        
        for(int i=0;i<k;i++){
            result[i] = cur;
            
            int partLength = partSize+(i<extraParts ? 1 : 0);
            
            for(int j=0;j<partLength;j++){
                prev = cur;
                cur = cur.next;
            }
            
            if(prev.next !=null){
                prev.next = null;
            }
            
        }
        
        return result;
    }
    
}









