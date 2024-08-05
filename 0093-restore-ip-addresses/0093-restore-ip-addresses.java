class Solution {
    
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int count = 0;
        String path = "";
        dfs(0,s,path,count,result);
        return result;
    }
    
    public void dfs(int ind,String s,String path,int count,List<String> result){
        
        int n = s.length();
          
        if(ind==s.length() && count==4){
            result.add(path);
            return;
        }
        
        if(count>=4){
            return;
        }
        
        
        int num = 0;
        
        for(int i=ind;i<s.length();i++){
            
            int curNum = s.charAt(i)-'0';
            
            num = (num*10)+curNum;
            
            
            if(num>=0 && num<=255){
                
                if(s.charAt(ind)=='0' && i>ind){
                    return;
                }
                
                if(ind==0){
                   dfs(i+1,s,path+""+num,count+1,result);
                }else{
                   dfs(i+1,s,path+"."+num,count+1,result);   
                }
            }
        }
        
    }
    
}