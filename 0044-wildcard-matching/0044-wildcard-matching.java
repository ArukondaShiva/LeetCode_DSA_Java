class Solution {
    
    public boolean isMatch(String p, String s) {
    
        int n1 = s.length();
        int n2 = p.length();
        
        int dp[][] = new int[n1][n2];
        
        for(int r[] : dp){
            Arrays.fill(r,-1);
        }
        
        return checkIsMatch(n1-1,n2-1,s,p,dp);
    }
    
    public boolean checkIsMatch(int i,int j,String s,String p,int dp[][]){
        
        if(i<0 && j<0){
            return true;
        }
        
        if(j>=0 && i<0){
            return false;
        }
        
        if(i>=0 && j<0){
           return checkAllStarts(s,i);
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j]==1 ? true : false;
        }
        
        
        if((s.charAt(i)==p.charAt(j)) || (s.charAt(i)=='?')){
            dp[i][j] = checkIsMatch(i-1,j-1,s,p,dp)==true ? 1 : 0;
            return dp[i][j] == 1 ? true : false;
        }
        else if(s.charAt(i)=='*'){
            dp[i][j] = (checkIsMatch(i-1,j,s,p,dp) || checkIsMatch(i,j-1,s,p,dp)) == true ? 1 : 0;
            return dp[i][j] == 1 ? true : false;
        }
        
        return false;
    }
    
    public boolean checkAllStarts(String s,int ind){
        for(int i=0;i<=ind;i++){
            if(s.charAt(i)!='*'){
                return false; 
            }
        }
        return true;
    }
    
}