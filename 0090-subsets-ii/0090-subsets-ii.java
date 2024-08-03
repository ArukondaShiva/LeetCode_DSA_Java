class Solution {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
    
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        
        for(int num=0;num<=Math.pow(2,n)-1;num++){
            
            List<Integer> subList = new ArrayList<>();
            
            for(int i=0;i<n;i++){
                if((num & (1<<i)) !=0){
                    subList.add(nums[i]);
                }
            }
            
            set.add(subList);
        }
        
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    
}