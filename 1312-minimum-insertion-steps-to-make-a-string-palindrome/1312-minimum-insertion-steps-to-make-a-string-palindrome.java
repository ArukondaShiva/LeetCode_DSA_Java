class Solution {
    
    public int minInsertions(String s) {
        int n = s.length();
        return n-LPS(s);
    }
    
    public int LPS(String s){
        int n = s.length();
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        return LCS(s1,s2,n);
    }
    
    public int LCS(String s1,String s2,int n){
        
        int dp[][] = new int[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=n;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1+dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2] = 0+Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }
        
        return dp[n][n];
    }
    
}