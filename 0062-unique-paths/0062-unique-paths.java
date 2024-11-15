class Solution {
    
    public int uniquePaths(int m, int n) {
        
        int dp[][] = new int[m][n];
            
        for(int i=0;i<m;i++){
            
            for(int j=0;j<n;j++){
                
                if(i==0 && j==0){
                    dp[i][j] = 1;
                    continue;
                }
                
                int top = 0;
                if(i>0){
                    top = dp[i-1][j];
                }
                
                int bottom = 0;
                if(j>0){
                    bottom = dp[i][j-1];
                }
                
                dp[i][j] = top+bottom;
            }
            
        }
        
        return dp[m-1][n-1];
        
    }
    
     
}