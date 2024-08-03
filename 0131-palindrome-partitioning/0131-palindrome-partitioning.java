class Solution {
    
    public List<List<String>> partition(String s) {
        
        List<List<String>> finalList = new ArrayList<>();
        List<String> path = new ArrayList<>();
        int n = s.length();
        generatePartitions(0,s,path,finalList,n);
        return finalList;
    }
    
    public void generatePartitions(int ind,String str,List<String> path, List<List<String>> finalList,int n){
        
        if(ind==n){
            finalList.add(new ArrayList<String>(path));
            return;
        }
        
        for(int i=ind;i<n;i++){
            if(isPalindrome(ind,i,str)){
                String palin = str.substring(ind,i+1);
                path.add(palin);
                generatePartitions(i+1,str,path,finalList,n);
                path.remove(path.size()-1);
            }
        }
        
    }
    
    public boolean isPalindrome(int i,int j,String str){
        
        while(i<=j){
            //System.out.println(i+" , "+j);
            if(str.charAt(i++)!=str.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    
}