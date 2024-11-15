class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        int dp[][] = new int[n][m];
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                    continue;
                }
                
                if(i==0 && j==0){
                    dp[i][j] = 1;
                    continue;
                }
                
                int up = 0;
                
                if(i>0){
                    up = dp[i-1][j];
                }
                
                int left = 0;
                
                if(j>0){
                    left = dp[i][j-1];
                }
                
                dp[i][j] = up+left;
            }
        }
        
        return dp[n-1][m-1];
    }
    
}