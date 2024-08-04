class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return func(0,s,wordDict,n,dp)==1;
    }
    
    public int func(int ind,String s,List<String> wordDict,int n,int dp[]){
        
        if(ind==n){
            return 1;
        }
        
        if(dp[ind]!=-1){
            return dp[ind];
        }
        
        String temp = "";
        
        for(int i=ind;i<n;i++){
            temp = temp+s.charAt(i);
            if(wordDict.contains(temp)){
                if(func(i+1,s,wordDict,n,dp)==1){
                    return dp[ind] = 1;
                }
            }
        }
        
        return dp[ind] = 0;
    
    }
    
}