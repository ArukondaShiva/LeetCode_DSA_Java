class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    
        Arrays.sort(candidates);
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = candidates.length;
        comSum2(0,target,candidates,ds,finalList,n);
        return finalList;
    }
    
    public void comSum2(int ind,int target,int candidates[],List<Integer> ds,List<List<Integer>> finalList,int n){
        
        if(target==0){
            finalList.add(new ArrayList<>(ds));
            return;
        }
        
        if(ind==n){
            return;
        }
        
        // pick
        for(int i=ind;i<n;i++){
            
            if(i>ind && candidates[i]==candidates[i-1]){
                continue;
            }
            
            if(candidates[i]<=target){
                ds.add(candidates[i]);
                comSum2(i+1,target-candidates[i],candidates,ds,finalList,n);
                ds.remove(ds.size()-1);
            }
        }
        
    }
    
}