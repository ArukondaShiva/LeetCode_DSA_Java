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
    
   public void reverse(ArrayList<Integer> arr,int i,int j){
       
       while(i<j){
           int temp = arr.get(i);
           arr.set(i,arr.get(j));
           arr.set(j,temp);
           i++;
           j--;
       }
        
   }
    
    public ListNode reverseEvenLengthGroups(ListNode head){
        
        if(head.next ==null){
            return head;
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        
        while(temp!=null){
            arr.add(temp.val);
            temp = temp.next;
        }
        
        int prev = 2;
        int ind = -1;
        
        int n = arr.size();
        for(int i=1;i+prev-1<n;){
            
            reverse(arr,i,i+prev-1);
            
            if(i+2*prev+1 >= n){
                ind = i+prev;
            }
            else{
                ind = i+2*prev+1;
            }
            
            i = i+2*prev+1;
            prev = prev+2;
            
        }
        
        if(ind<n && (n-ind)%2==0){
            reverse(arr,ind,n-1);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        
        for(int it : arr){
            ListNode t = new ListNode(it);
            node.next = t;
            node = node.next;
        }
        return dummy.next;
    }
                                            
}