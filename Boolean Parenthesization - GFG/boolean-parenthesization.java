//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int countWays(int N, String S){
        
        int dp[][][] = new int[N][N][2];
        
        for(int row[][] : dp){
            for(int row2[] : row){
                Arrays.fill(row2,-1);
            }
        }
        
        return evaluate(0,N-1,1,S,dp);
    }
    
    static int evaluate(int i,int j,int isTrue,String s,int dp[][][]){
        
        if(i>j){
            return 0;
        }
        
        if(i==j){
            if(isTrue==1){
                return s.charAt(i)=='T' ? 1 : 0;
            }else{
                return s.charAt(i)=='F' ? 1 : 0;
            }
        }
        
        if(dp[i][j][isTrue]!=-1){
            return dp[i][j][isTrue];
        }
        
        int ways = 0;
        int mod = 1003;
        
        for(int ind=i+1;ind<=j-1;ind=ind+2){
            
            int LT = evaluate(i,ind-1,1,s,dp);
            int LF = evaluate(i,ind-1,0,s,dp);
            int RT = evaluate(ind+1,j,1,s,dp);
            int RF = evaluate(ind+1,j,0,s,dp);
            
            if(s.charAt(ind)=='&'){
                
                if(isTrue==1){
                    ways = (ways+((LT*RT)%mod))%mod;
                }
                else{
                    ways = (ways+((LT*RF)%mod)+((LF*RT)%mod)+((LF*RF)%mod))%mod;
                }
            }
            
            else if(s.charAt(ind)=='|'){
                
                if(isTrue==1){
                    ways = (ways+((LT*RT)%mod)+((LT*RF)%mod)+((LF*RT)%mod))%mod;
                }
                else{
                    ways = (ways+(LF*RF)%mod)%mod;
                }
            }
            
            else{
                if(isTrue==1){
                    ways = (ways+((LT*RF)%mod)+((LF*RT)%mod))%mod;
                }
                else{
                    ways = (ways+((LT*RT)%mod)+((LF*RF)%mod))%mod;
                }
            }
        }
        
        
        return dp[i][j][isTrue] = ways%mod;
        
    }
    
}