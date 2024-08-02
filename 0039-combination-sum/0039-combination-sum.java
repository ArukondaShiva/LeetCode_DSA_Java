class Solution {
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = candidates.length;
        comSum(0,candidates,target,ds,finalList,n);
        return finalList;
    }
    
    public void comSum(int ind,int candidates[],int target,List<Integer> ds,List<List<Integer>> finalList,int n){
        
        if(ind==n){
            if(target==0){
                finalList.add(new ArrayList<Integer>(ds));
            }
            return;
        }
        
        // pick
        if(candidates[ind]<=target){
            ds.add(candidates[ind]);
            comSum(ind,candidates,target-candidates[ind],ds,finalList,n);
            ds.remove(new Integer(candidates[ind]));
        }
        
        // not pick
        comSum(ind+1,candidates,target,ds,finalList,n);
        
    }
    
    
}