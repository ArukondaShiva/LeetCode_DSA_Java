class Solution {
    
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2*k];
        for(int r[] : dp){
            Arrays.fill(r,-1);
        }
        return fun(0,0,k,n,prices,dp);
    }
    
    public int fun(int ind,int traNo,int k,int n,int prices[],int dp[][]){
        
        if(ind==n || traNo==2*k){
            return 0;
        }
        
        if(dp[ind][traNo]!=-1){
            return dp[ind][traNo];
        }
        
        if(traNo%2==0){ //buy
            return dp[ind][traNo] = Math.max(-prices[ind]+fun(ind+1,traNo+1,k,n,prices,dp), 0+fun(ind+1,traNo,k,n,prices,dp));
        }else{ // sell
            return dp[ind][traNo] = Math.max(prices[ind]+fun(ind+1,traNo+1,k,n,prices,dp), 0+fun(ind+1,traNo,k,n,prices,dp));
        }
        
    }
    
}