class Solution {
    
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int ans = 0;
        
        for(int i=0;i<n;i++){
           left = Math.max(left,nums[i]);
           right = right+nums[i];
        }
        
        while(left<=right){
            int mid = (left+right)/2;
            if(isPossible(nums,mid,k)){
                ans = mid;
                right = mid-1;
            }else{
               left = mid+1;   
            }
        }
        
        return ans;
    }
    
    public boolean isPossible(int nums[],int mid,int k){
        
        int count = 0;
        int subarraySum = 0;
        
        for(int i=0;i<nums.length;i++){
            subarraySum = subarraySum+nums[i];
            if(subarraySum>mid){
                count++;
                subarraySum = nums[i];
            }
        }
        
        count++;
        return count<=k;
    }
    
    
    
}