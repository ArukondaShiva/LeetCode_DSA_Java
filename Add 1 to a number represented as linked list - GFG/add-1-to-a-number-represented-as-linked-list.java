//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) { 
        head = reverse(head);
        Node temp = new Node(-1);
        
        int carry = 1;
        Node dummy = temp;
        
        while(head!=null || carry>0){
            int sum = 0;
            if(head!=null){
                sum += head.data;
                head = head.next;
            }
            
            sum += carry;
            carry = sum/10;
            
            Node newNode = new Node(sum%10);
            temp.next = newNode;
            temp = temp.next;
            
        }
        
        
        return reverse(dummy.next);
        
    }
    
    public static Node reverse(Node head){
        
        Node prev = null;
        
        while(head!=null){
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
    
}



