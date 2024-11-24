class Solution {
    
    public int maxProfit(int[] prices) {
    
        int n = prices.length;
        int cap = 2;
        int buy = 0;
        int dp[][][] = new int[n][2][3];
        for(int r1[][] : dp){
            for(int r2[] : r1){
                Arrays.fill(r2,-1);
            }
        }
        return findMaxProfit(0,buy,cap,prices,n,dp);
    }
    
    public int findMaxProfit(int ind,int buy,int cap,int prices[],int n,int dp[][][]){
        
        if(ind==n || cap==0){
            return 0;
        }
        
        if(dp[ind][buy][cap]!=-1){
            return dp[ind][buy][cap]; 
        }
        
        int op1;
        int op2;
        
        if(buy==0){
            op1 = findMaxProfit(ind+1,buy,cap,prices,n,dp);
            op2 = -prices[ind] + findMaxProfit(ind+1,1-buy,cap,prices,n,dp);
        }else{
            op1 = findMaxProfit(ind+1,buy,cap,prices,n,dp);
            op2 = prices[ind] + findMaxProfit(ind+1,1-buy,cap-1,prices,n,dp);
        }
        
        return dp[ind][buy][cap] = Math.max(op1,op2);
    }
    
}