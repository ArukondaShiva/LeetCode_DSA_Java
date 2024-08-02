class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
    
        List<List<Integer>> finalList = new ArrayList<>();
        
        int n = nums.length;
        
        for(int num=0;num<=Math.pow(2,n)-1;num++){
            
            List<Integer> subList = new ArrayList<>();
            
            for(int i=0;i<n;i++){
               if((num &(1<<i))!=0){
                   subList.add(nums[i]);  
               }
            }
            
            finalList.add(subList);
        }
        
        return finalList;
    }
    
}