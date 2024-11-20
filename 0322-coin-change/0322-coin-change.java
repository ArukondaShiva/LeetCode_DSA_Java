class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int r[] : dp){
            Arrays.fill(r,-1);
        }
        int ans = findCoinChange(n-1,coins,amount,dp);
        return ans==(1e9) ? -1 : ans;
    }
    
    public int findCoinChange(int ind,int coins[],int amount,int dp[][]){
        
        if(ind==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }else{
                return (int)(1e9);
            }
        }
        
        
        if(dp[ind][amount]!=-1){
            return dp[ind][amount];
        }
        
        int notTaken = findCoinChange(ind-1,coins,amount,dp);
        
        int taken = (int)(1e9);
        
        if(coins[ind]<=amount){
            taken = 1+findCoinChange(ind,coins,amount-coins[ind],dp);
        }
        
        return dp[ind][amount] = Math.min(notTaken,taken);
    }
    
}