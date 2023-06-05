class Solution {
    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return countWays(n-1,amount,coins,dp);

    }

    public int countWays(int ind,int amount,int coins[],int dp[][]){

      if(ind==0){
           if(amount%coins[0]==0){
               return 1;
           }else{
               return 0;
           }
      }

      if(dp[ind][amount]!=-1){
          return dp[ind][amount];
      }

      int notTake = countWays(ind-1,amount,coins,dp);

      int take = 0;
      if(coins[ind]<=amount){
          take = countWays(ind,amount-coins[ind],coins,dp);
      }

      return dp[ind][amount] = notTake+take;

    }


}