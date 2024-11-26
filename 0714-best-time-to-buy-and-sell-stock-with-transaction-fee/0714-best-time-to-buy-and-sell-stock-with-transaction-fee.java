class Solution {
    
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int r[] : dp){
            Arrays.fill(r,-1);
        }
        return findMaxProfit(0,0,n,prices,fee,dp);
    }
    
    public int findMaxProfit(int ind,int buy,int n,int prices[],int fee,int dp[][]){
        
        if(ind==n){
            return 0;
        }
        
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        
        int op1;
        int op2;
        
        if(buy==0){ // buy
            op1 = 0 + findMaxProfit(ind+1,0,n,prices,fee,dp);
            op2 = -prices[ind] + findMaxProfit(ind+1,1,n,prices,fee,dp);
        }else{
            op1 = 0 + findMaxProfit(ind+1,1,n,prices,fee,dp);
            op2 = prices[ind] - fee + findMaxProfit(ind+1,0,n,prices,fee,dp);
        }
        
        return dp[ind][buy] = Math.max(op1,op2);
    }
    
}