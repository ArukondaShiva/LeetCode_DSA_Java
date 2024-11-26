class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length; 
        int dp[][] = new int[n+2][2];
        
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                int op1,op2;
                if(buy==0){
                    op1 = 0 + dp[ind+1][0];
                    op2 = -prices[ind] + dp[ind+1][1];
                }else{
                    op1 = 0 + dp[ind+1][1];
                    op2 = prices[ind] + dp[ind+2][0];
                }
                dp[ind][buy] = Math.max(op1,op2);
            }
        }
        
        return dp[0][0];
    }
    
   
}