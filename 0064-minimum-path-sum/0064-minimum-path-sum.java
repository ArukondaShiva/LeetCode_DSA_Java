class Solution {
    
    public int minPathSum(int[][] grid) {
    
        int n = grid.length;
        int m = grid[0].length;
        
        int dp[][] = new int[n][m];
        
        /*
        for(int r[] : dp){
            Arrays.fill(r,-1);
        }
        return findMinPathSum(n-1,m-1,grid,dp);
        */
        
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                
                if(i==0 && j==0){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                
                int up = grid[i][j];
                
                if(i>0){
                    up += dp[i-1][j];
                }else{
                    up += (int)(1e9);
                }
                
                int left = grid[i][j] ;
                
                if(j>0){
                    left += dp[i][j-1];
                }else{
                    left += (int)(1e9);
                }
                
                dp[i][j] = Math.min(up,left);
            }
        }
        
        return dp[n-1][m-1];
    }
    
    
    
    public int findMinPathSum(int i,int j,int grid[][],int dp[][]){
        
        if(i==0 && j==0){
            return grid[0][0];
        }
        
        if(i<0 || j<0){
            return (int)1e9;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int up = grid[i][j] + findMinPathSum(i-1,j,grid,dp);
        int left = grid[i][j] + findMinPathSum(i,j-1,grid,dp);
        
        return dp[i][j] = Math.min(up,left);
    }
    
}
