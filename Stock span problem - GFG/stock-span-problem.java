//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    
    public static int[] calculateSpan(int price[], int n){
        
        Stack<Integer> st = new Stack<>();
        
        int res[] = new int[n];
        
        for(int i=0;i<n;i++){
            
            while(!st.isEmpty() && price[st.peek()]<=price[i]){
                st.pop();
            }
            
            res[i] = st.isEmpty()==true ? i+1 : i-st.peek();
            
            st.push(i);
        
        }
        
        return res;
        
    }
    
}