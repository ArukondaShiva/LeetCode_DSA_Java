class Solution {
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        int prev2 = 0;
        int prev1 = nums[0];
        
        for(int ind=1;ind<n;ind++){
            
            int pick = nums[ind];
            
            if(ind>1){
               pick += prev2;
            }
            
            int notPick = 0+prev1;
            
            
            prev2 = prev1;
            prev1 = Math.max(pick,notPick);
        }
        
        return prev1;
    }
    
    
    
}