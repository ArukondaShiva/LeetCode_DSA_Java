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

    public ListNode mergeKLists(ListNode[] lists) {
    
        int n = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        
        for(int i=0;i<n;i++){
            if(lists[i]==null){
                continue;
            }
            pq.add(lists[i]);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
        while(pq.size()>0){
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;
            if(node.next!=null){
                pq.add(node.next);
            }
        }
        
        return dummy.next;
    }
    
}



