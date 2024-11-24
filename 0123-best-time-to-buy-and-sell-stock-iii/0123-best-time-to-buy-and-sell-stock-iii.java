class Solution {
    
    public int maxProfit(int[] prices) {
    
        int n = prices.length; 
        
        int dp[][][] = new int[n+1][2][3];
        
        dp[n][0][0] = dp[n][0][1] = dp[n][0][2] = 0;
        dp[n][1][0] = dp[n][1][1] = dp[n][1][2] = 0;
        
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    
                    int op1;
                    int op2;
                    
                    if(buy==0){
                        op1 = dp[ind+1][buy][cap];
                        op2 = -prices[ind] + dp[ind+1][1][cap];
                    }else{
                        op1 = dp[ind+1][buy][cap];
                        op2 = prices[ind] + dp[ind+1][0][cap-1];
                    }
                    
                    dp[ind][buy][cap] = Math.max(op1,op2);
                }
            }
        }
        
        return dp[0][0][2];
    }
    
   
}