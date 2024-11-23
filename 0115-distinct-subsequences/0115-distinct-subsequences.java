class Solution {
    
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int dp[][] = new int[n1][n2];
        for(int r[]:dp){
            Arrays.fill(r,-1);
        }
        return findDistinct(n1-1,n2-1,s,t,dp);
    }
    
    public int findDistinct(int i,int j,String s,String t,int dp[][]){
        
        if(j<0){
            return 1;
        }
        
        if(i<0){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = findDistinct(i-1,j-1,s,t,dp)+findDistinct(i-1,j,s,t,dp);
        }else{
            return dp[i][j] = findDistinct(i-1,j,s,t,dp);
        }
        
    }
    
}