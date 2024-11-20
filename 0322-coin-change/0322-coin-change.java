class Solution {
    
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        
        for(int am=0;am<=amount;am++){
            if(am%coins[0]==0){
                dp[0][am] = am/coins[0];
            }else{
                dp[0][am] = (int)(1e9);
            }
        }
        
        for(int ind=1;ind<n;ind++){
            
            for(int target=0;target<=amount;target++){
                
                int notTaken = 0+dp[ind-1][target];
                
                int taken = (int)(1e9);
                
                if(coins[ind]<=target){
                    taken = 1+dp[ind][target-coins[ind]];
                }
                
                dp[ind][target] = Math.min(notTaken,taken);
            }
        }
        
        int ans = dp[n-1][amount];
        
        if(ans==(int)(1e9)){
            return -1;
        }else{
            return ans;
        }
    }
    
}