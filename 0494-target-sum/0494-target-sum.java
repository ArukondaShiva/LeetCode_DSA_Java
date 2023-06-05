class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int toSum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            toSum += nums[i];
        }

        if(toSum-target<0){
            return 0;
        }
        if((toSum-target)%2==1){
           return 0;
        }

        int s2 = (toSum-target)/2;

        int dp[][] = new int[n][s2+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }

        return countTargetSum(n-1,s2,nums,dp);

    }

    public int countTargetSum(int ind,int s2,int nums[],int dp[][]){

        if(ind==0){
            if(s2==0 && nums[ind]==0){
                return 2;
            }
            else if(s2==0 || nums[ind]==s2){
                return 1;
            }
            return 0;
        }

        if(dp[ind][s2]!=-1){
            return dp[ind][s2];
        }
        
        int notTake = countTargetSum(ind-1,s2,nums,dp);
        int take = 0;
        if(nums[ind]<=s2){
            take = countTargetSum(ind-1,s2-nums[ind],nums,dp);
        }
        
        return dp[ind][s2] = notTake+take;
    }


}














