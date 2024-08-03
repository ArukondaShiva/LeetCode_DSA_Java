class Solution {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
    
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = nums.length;
        
        generateSubsets(0,nums,ds,finalList,n);
        return finalList;
    }
    
    
    public void generateSubsets(int ind,int nums[],List<Integer> ds,List<List<Integer>> finalList,int n){
        
        finalList.add(new ArrayList<Integer>(ds));
        
        for(int i=ind;i<n;i++){
            
            if(i>ind && nums[i]==nums[i-1]){
                continue;
            }
            
            ds.add(nums[i]);
            generateSubsets(i+1,nums,ds,finalList,n);
            ds.remove(ds.size()-1);
        }
        
    }
    
}