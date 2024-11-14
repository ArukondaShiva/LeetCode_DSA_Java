class Solution {
    
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return findMaxRob(n-1,nums,dp);
    }
    
    public int findMaxRob(int ind,int nums[],int dp[]){
        
        if(ind<0){
            return 0;
        }
                
        if(ind==0){
            return nums[0];
        }
        
        if(dp[ind]!=-1){
            return dp[ind];
        }
        
        int pick = nums[ind]+findMaxRob(ind-2,nums,dp);
        int notPick = 0+findMaxRob(ind-1,nums,dp);
        
        return dp[ind] = Math.max(pick,notPick);
    }
    
    
}