class Solution {
    
    public int removeElement(int[] nums, int val) {
    
        int n = nums.length;
        int i = 0;
        int j = n-1;
        
        int k = 0;
        while(i<=j){
            if(nums[i]==val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
            else{
                i++;
                k++;
            }
        }
        
        return k;
    }
    
}