/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        //STEP-1
        //creating alternate nodes
        Node current=head;
        while(current!=null){
          Node next=current.next;
          current.next=new Node(current.val);
          current.next.next=next;
          current=next;
        }
        
        
        //STEP-2
        current=head;
        for(current=head;current!=null;current=current.next.next){
            current.next.random = (current.random!=null)? current.random.next : null;
        }
        
        //STEP-3
        Node newNode = new Node(0);
        Node CopyCurr = newNode;
        current = head;
        
        while(current!=null){
            CopyCurr.next = current.next;
            current.next = CopyCurr.next.next;
            current=current.next;
            CopyCurr=CopyCurr.next;
        }
        
        return newNode.next;
        
    }
}