//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
     
    public static String infixToPostfix(String exp) {
         
         HashMap<Character,Integer> priority = new HashMap<>();
         
         priority.put('+',1);
         priority.put('-',1);
         priority.put('*',2);
         priority.put('/',2);
         priority.put('^',3);
         priority.put('(',0);
         
         Stack<Character> st = new Stack();
         String ans="";
         
         for(int i=0;i<exp.length();i++){
             
             char ch = exp.charAt(i);
             
             if(ch=='('){
                st.push(ch);        
             }
             
             else if(ch==')'){
                 
                 while(st.peek()!='('){
                     ans = ans+st.peek();
                     st.pop();
                 }
                 st.pop();
             }
             
             else if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^' || ch=='('){
                 while(!st.isEmpty() && priority.get(st.peek())>=priority.get(ch)){
                     ans = ans+st.peek();
                     st.pop();
                 }
                 st.push(ch);
             }
             else{
                 ans = ans+ch;
             }
         }
         
         while(!st.isEmpty()){
             ans = ans+st.peek();
             st.pop();
         }
         
         return ans;
    }
    
    
    
}