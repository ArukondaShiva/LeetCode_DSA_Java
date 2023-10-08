class Solution {
    
    public int missingNumber(int[] nums) {
    
        int totxor = 0;
        
        for(int i=0;i<=nums.length;i++){
            totxor = totxor^i;
        }
        
        for(int x : nums){
            totxor = totxor ^ x;
        }
        
        return totxor;
    }
    
}