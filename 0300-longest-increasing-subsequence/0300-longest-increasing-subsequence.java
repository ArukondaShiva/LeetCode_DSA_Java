class Solution {
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int prev_ind = -1;
        int dp[][] = new int[n][n+1];
        for(int r[]:dp){
            Arrays.fill(r,-1);
        }
        return findLIS(0,prev_ind,nums,n,dp);
    }
    
    public int findLIS(int ind,int prev_ind,int nums[],int n,int dp[][]){
        
        if(ind==n){
             return 0;
        }
        
        if(dp[ind][prev_ind+1]!=-1){
            return dp[ind][prev_ind+1];
        }
        
        int notTake = 0+findLIS(ind+1,prev_ind,nums,n,dp);

        int take = 0;        
        if(prev_ind==-1 || nums[ind]>nums[prev_ind]){
            take = 1+findLIS(ind+1,ind,nums,n,dp);
        }
        
        return dp[ind][prev_ind+1]=Math.max(notTake,take);
        
    }
    
}