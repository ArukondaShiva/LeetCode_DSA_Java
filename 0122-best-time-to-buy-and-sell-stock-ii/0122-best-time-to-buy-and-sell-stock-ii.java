class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int dp[][] = new int[n][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        
        return buySell(0,0,prices,n,dp);
    }
    
    public int buySell(int ind,int buy,int prices[],int n,int dp[][]){
        
        if(ind==n){
            return 0;
        }
        
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        
        int op1;
        int op2;
        
        if(buy==0){
            //not buy
           op1 = buySell(ind+1,buy,prices,n,dp);
            //buy
           op2 = -prices[ind]+buySell(ind+1,buy+1,prices,n,dp);
        }
        else{
            //not sell
            op1 = buySell(ind+1,buy,prices,n,dp);
            op2 = prices[ind]+buySell(ind+1,buy-1,prices,n,dp);
        }
        
        return dp[ind][buy] = Math.max(op1,op2);
    }
    
}