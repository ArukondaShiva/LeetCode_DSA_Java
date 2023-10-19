class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
    
        int n = numbers.length;
        int low = 0;
        int high = n-1;
        
        while(low<=high){
            if(numbers[low]+numbers[high]==target){
                return new int[]{low+1,high+1};
            }
            else if(numbers[low]+numbers[high]<target){
                low++;
            }
            else{
                high--;
            }
        }
        
        return new int[]{};
    }
    
}