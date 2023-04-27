//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.solve(a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static int solve(int bt[]) {
        
    int n = bt.length;
       Arrays.sort(bt);
       
       int ans = 0; //total waiting time
       int time = 0; //sum of execution times for processes(burst times)
       
       for(int i=0;i<n;i++){
           ans = ans+time;
           time = time+bt[i];
       }
       
       //we ned avg waiting time
       return ans/n;
    }
    
    
}
     