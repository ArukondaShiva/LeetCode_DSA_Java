class Solution {
    
    public int cherryPickup(int[][] grid) {
    
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];
        
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2){
                    dp[n-1][j1][j2] = grid[n-1][j1];
                }else{
                    dp[n-1][j1][j2] = grid[n-1][j1]+grid[n-1][j2];
                }
            }
        }
        
        
        for(int i=n-2;i>=0;i--){
            
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    
                    int maxi = Integer.MIN_VALUE;
                    
                    for(int dj1=-1;dj1<=1;dj1++){
                        
                        for(int dj2=-1;dj2<=1;dj2++){
                            
                            int ans = 0;
                        
                            if(j1==j2){
                              ans = grid[i][j1];
                            }else{
                              ans = grid[i][j1]+grid[i][j2];
                            }
                            
                            if(j1+dj1<0 || j1+dj1>=m || j2+dj2<0 || j2+dj2>=m){
                                 ans += (int)(-1e9);
                            }else{
                                ans += dp[i+1][j1+dj1][j2+dj2];
                            }
                            
                            maxi = Math.max(maxi,ans);
                        }
                    }
                    
                    dp[i][j1][j2] = maxi;
                }
            }
            
        }
        
        return dp[0][0][m-1];
    }
    
}