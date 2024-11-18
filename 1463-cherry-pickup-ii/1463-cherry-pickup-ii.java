class Solution {
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];
        
        for(int r1[][] : dp){
            for(int r2[] : r1){
                Arrays.fill(r2,-1);
            }
        }
        
        return findCherries(0,0,m-1,n,m,grid,dp);
    }
    
    public int findCherries(int i,int j1,int j2,int n,int m,int grid[][],int dp[][][]){
        
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return (int)(-1e9);
        }
        
        if(i==n-1){
            if(j1==j2){
                return grid[i][j1];
            }else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        
        int maxCherries = 0;
        
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                
                int curCherries;
                
                if(j1==j2){
                    curCherries = grid[i][j1]+findCherries(i+1,j1+dj1,j2+dj2,n,m,grid,dp);
                }
                else{
                    curCherries = grid[i][j1]+grid[i][j2]+findCherries(i+1,j1+dj1,j2+dj2,n,m,grid,dp);
                }
                
                maxCherries = Math.max(maxCherries,curCherries);
            }
        }
        
        return dp[i][j1][j2] = maxCherries;
    }
    
}