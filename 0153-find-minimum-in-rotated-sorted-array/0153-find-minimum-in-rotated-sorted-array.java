class Solution {
    
    public int findMin(int[] nums) {
    
        int n = nums.length;
        
        if(nums[0]<=nums[n-1]){
            return nums[0];
        }
        
        int low = 0;
        int high = n-1;
        
        while(low<high){
            int mid = (low+high)/2;
            
            if(nums[low]<nums[mid]){
                low = mid;
            }
            else if(nums[low]>nums[mid]){
                high = mid;
            }
            else if(nums[mid]==nums[low]){
                return nums[high];
            }
            
        }
        
        return -1;
    }
    
}