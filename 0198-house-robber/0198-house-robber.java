class Solution {
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        int dp[] = new int[n];
        
        dp[0] = nums[0];
        
        for(int ind=1;ind<n;ind++){
            
            int pick = nums[ind];
            
            if(ind>1){
               pick += dp[ind-2];
            }
            
            int notPick = 0+dp[ind-1];
            
            dp[ind] = Math.max(pick,notPick);
        }
        
        return dp[n-1];
    }
    
    
    
}