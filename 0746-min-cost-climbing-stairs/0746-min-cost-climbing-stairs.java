class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n + 1];
        dp[n] = 0;
        
        for(int ind=n-1;ind>=0;ind--){
            int oneStep = cost[ind]+dp[ind+1];
            int twoStep = Integer.MAX_VALUE;
            if(ind+2<=n){
                twoStep = cost[ind]+dp[ind+2];
            }
            dp[ind] = Math.min(oneStep,twoStep);
        }
        
        return Math.min(dp[0],dp[1]);
    }
}
