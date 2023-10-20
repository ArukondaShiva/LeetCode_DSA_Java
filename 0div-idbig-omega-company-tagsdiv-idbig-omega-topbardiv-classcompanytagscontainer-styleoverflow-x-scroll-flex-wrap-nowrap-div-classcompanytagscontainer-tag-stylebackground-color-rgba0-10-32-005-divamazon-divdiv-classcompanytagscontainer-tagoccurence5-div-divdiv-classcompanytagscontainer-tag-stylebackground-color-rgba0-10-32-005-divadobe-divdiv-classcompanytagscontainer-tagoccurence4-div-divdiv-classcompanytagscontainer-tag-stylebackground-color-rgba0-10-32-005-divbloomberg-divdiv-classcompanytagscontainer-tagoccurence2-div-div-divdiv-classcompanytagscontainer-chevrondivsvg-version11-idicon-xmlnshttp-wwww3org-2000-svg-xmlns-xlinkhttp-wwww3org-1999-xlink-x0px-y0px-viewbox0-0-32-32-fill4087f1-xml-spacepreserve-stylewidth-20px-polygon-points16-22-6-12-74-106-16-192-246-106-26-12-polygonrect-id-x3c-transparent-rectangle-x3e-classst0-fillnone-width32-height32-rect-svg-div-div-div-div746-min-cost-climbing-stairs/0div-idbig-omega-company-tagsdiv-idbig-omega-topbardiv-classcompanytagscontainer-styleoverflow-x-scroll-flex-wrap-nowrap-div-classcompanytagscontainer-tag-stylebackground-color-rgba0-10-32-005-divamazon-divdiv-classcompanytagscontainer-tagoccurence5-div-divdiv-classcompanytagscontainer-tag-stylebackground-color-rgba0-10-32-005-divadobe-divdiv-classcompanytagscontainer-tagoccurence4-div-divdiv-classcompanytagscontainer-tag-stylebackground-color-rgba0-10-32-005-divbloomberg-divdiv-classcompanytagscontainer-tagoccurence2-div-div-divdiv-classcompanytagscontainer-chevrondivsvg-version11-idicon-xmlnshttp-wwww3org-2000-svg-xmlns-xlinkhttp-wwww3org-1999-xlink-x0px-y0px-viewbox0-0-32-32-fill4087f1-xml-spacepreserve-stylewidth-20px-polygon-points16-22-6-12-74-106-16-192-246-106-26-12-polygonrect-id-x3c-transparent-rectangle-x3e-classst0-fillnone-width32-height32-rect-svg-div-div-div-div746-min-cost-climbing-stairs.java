class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(f(0, cost, n, dp), f(1, cost, n, dp));
    }

    public int f(int ind, int cost[], int n, int dp[]) {
        if (ind == n) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int oneStep = cost[ind] + f(ind + 1, cost, n, dp);
        int twoStep = Integer.MAX_VALUE;
        if (ind + 2 <= n) {
            twoStep = cost[ind] + f(ind + 2, cost, n, dp);
        }
        return dp[ind] = Math.min(oneStep, twoStep);
    }
}
