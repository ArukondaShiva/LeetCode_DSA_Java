class Solution {
    public int minDistance(String word1, String word2) {
        
        int n1 = word1.length();
        int n2 = word2.length();
        
        return min_steps(n1,n2,word1,word2);

    }
    
    
    public int min_steps(int n1,int n2,String s1,String s2){
       
      return solveSteps(s1,s2,n1,n2);
        
    }
    
    public int solveSteps(String s1,String s2,int n1,int n2){
    
      int dp[][] = new int[n1+1][n2+1];
        
     
        for(int i=0;i<=n1;i++){
            dp[i][0] = i;
        }
        
        for(int j=0;j<=n2;j++){
            dp[0][j] = j;
        }
        
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 0+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));    
                }
            }
        }
    
        return dp[n1][n2];
    }
    
    
}