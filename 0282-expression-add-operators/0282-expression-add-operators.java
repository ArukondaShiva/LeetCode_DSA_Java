class Solution {
    
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        dfs(num,target,0,"",0,0,ans);
        return ans;
    }
    
    public void dfs(String s,int target,int i,String path,long result,long prevValue,List<String> ans){
        
        if(i==s.length()){
            if(result==target){
                ans.add(path);
                return;
            }
        }
        
        String curStr = "";
        long num = 0;
        
        for(int j=i;j<s.length();j++){
            
            if(j>i && s.charAt(i)=='0'){
                return;
            }
            
            curStr += s.charAt(j);
            num = (num*10)+s.charAt(j)-'0';
            
            if(i==0){
                dfs(s,target,j+1,path+curStr,num,num,ans);
            }else{
                dfs(s,target,j+1,path+"+"+curStr,result+num,num,ans);
                dfs(s,target,j+1,path+"-"+curStr,result-num,-num,ans);
                dfs(s,target,j+1,path+"*"+curStr,(result-prevValue+(prevValue*num)),prevValue*num,ans);
            }
            
        }
        
    }
    
}