class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        int dp[][] = new int[n][m];
        
        for(int r[] : dp){
            Arrays.fill(r,-1);
        }
    
        return findUniquePaths(n-1,m-1,obstacleGrid,dp);
    }
    
    public int findUniquePaths(int i,int j,int obstacleGrid[][],int dp[][]){
        
        if(i>=0 && j>=0 && obstacleGrid[i][j]==1){
            return 0;
        }
        
        if(i==0 && j==0){
            return 1;
        }
        
        if(i<0 || j<0){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int up = findUniquePaths(i-1,j,obstacleGrid,dp);
        int left = findUniquePaths(i,j-1,obstacleGrid,dp);
        
        return dp[i][j] = up+left;
    }
        
    
}