class Solution {
    public int minDistance(String word1, String word2) {
        
        int n1 = word1.length();
        int n2 = word2.length();
        
        return min_steps(n1,n2,word1,word2);

    }
    
    
    public int min_steps(int n1,int n2,String s1,String s2){
        
      int dp[][] = new int[n1][n2];
        
      for(int row[]:dp){
          Arrays.fill(row,-1);
      }
        
      return solveSteps(n1-1,n2-1,s1,s2,dp);
        
    }
    
    public int solveSteps(int i,int j,String s1,String s2,int dp[][]){
        
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j] = 0+solveSteps(i-1,j-1,s1,s2,dp);
        }
        else{
           dp[i][j] = 1+Math.min(solveSteps(i,j-1,s1,s2,dp),Math.min(solveSteps(i-1,j,s1,s2,dp),solveSteps(i-1,j-1,s1,s2,dp)));    
        }
        
        return dp[i][j];
        
    }
    
    
}