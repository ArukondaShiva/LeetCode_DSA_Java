class Solution {
    
    public int smallestDivisor(int[] nums, int threshold) {
    
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            maxi = Math.max(nums[i],maxi);
        }
        
        int low = 1;
        int high = maxi;
        
        int ans = -1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(canDivisionPossible(nums,mid,threshold)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return ans;
    }
    
    public boolean canDivisionPossible(int nums[],int num,int threshold){
        
        int divSum = 0;
        
        for(int i=0;i<nums.length;i++){
            divSum = divSum + (int)Math.ceil(((double)nums[i])/num);
        }
        
        return divSum<=threshold;
    }
    
}