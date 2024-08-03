class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        genCombinations(1,0,k,ds,finalList,n);
        return finalList;
    }
    
    public void genCombinations(int num,int sum,int k,List<Integer> ds,List<List<Integer>> finalList,int n){
        
        if(ds.size()==k){
            if(sum==n){
                finalList.add(new ArrayList<Integer>(ds));
            } 
            return;
        }
        
        for(int curNum=num;curNum<=9;curNum++){
            ds.add(curNum);
            genCombinations(curNum+1,sum+curNum,k,ds,finalList,n);
            ds.remove(ds.size()-1);
        }
        
    }
}