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
    
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        List<Integer> list = new ArrayList<>();
        
        ListNode prev = head;
        ListNode cur = head.next;
        
        int count = 2;
        while(cur.next!=null){
            if(cur.val>prev.val && cur.val>cur.next.val){
                list.add(count);
            }
            if(cur.val<prev.val && cur.val<cur.next.val){
                list.add(count);
            }
            count++;
            cur = cur.next;
            prev = prev.next;
        }
        
        if(list.size()<2){
            return new int[]{-1,-1};
        }
        
        int minVal = list.get(0);
        int maxVal = list.get(0);
        
        int minDiff = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        
        for(int i=1;i<list.size();i++){
            minDiff = Math.min(minDiff,list.get(i)-maxVal);
            maxDiff = Math.max(maxDiff,list.get(i)-minVal);
            
            minVal = Math.min(minVal,list.get(i));
            maxVal = Math.max(maxVal,list.get(i));
        }
        
        return new int[]{minDiff,maxDiff};
        
    }
    
}