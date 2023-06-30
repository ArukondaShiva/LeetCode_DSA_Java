//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		
    		//input n and d
    	    int n=Integer.parseInt(str);
    		Stack<Integer> stack=new Stack<>();
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		    stack.push(Integer.parseInt(starr1[j]));
    		}
    		//calling reverse() function
            Solution.reverse(stack);
            for(int j:stack){
                out.print(j+" ");
            }
            out.println();
         }
         out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    
    static void reverse(Stack<Integer> s){
        reverseStack(s);
    }
    
    static Stack<Integer> reverseStack(Stack<Integer> s){
        if(s.size()>0){
            int element = s.peek();
            s.pop();
            reverseStack(s);
            insert_bottom(s,element);
        }
        return s;
    }
    
    static Stack<Integer> insert_bottom(Stack<Integer> s,int x){
        
        if(s.size()==0){
            s.push(x);
        }
        else{
            int element = s.peek();
            s.pop();
            insert_bottom(s,x);
            s.push(element);
        }
        
        return s;
    }
    
}