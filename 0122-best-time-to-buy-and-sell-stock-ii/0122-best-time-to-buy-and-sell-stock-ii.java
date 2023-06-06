class Solution {
    
    public int maxProfit(int[] prices) {
    
        int n = prices.length;
        
        int dp[][] = new int[n+1][2];
        
        for(int i=0;i<=1;i++){
            dp[n][i] = 0;
        }
        
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                
                int profit;
                
                if(buy==0){
                    profit = Math.max(0+dp[ind+1][buy],-prices[ind]+dp[ind+1][1-buy]);
                }else{
                    profit = Math.max(0+dp[ind+1][buy],prices[ind]+dp[ind+1][1-buy]);
                }
                dp[ind][buy] = profit;
            }
        }
        
        return dp[0][0];
        
    }
    
}