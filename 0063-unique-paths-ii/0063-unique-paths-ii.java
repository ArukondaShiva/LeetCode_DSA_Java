class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int prev[] = new int[m];
        
        for(int i=0;i<n;i++){
            
            int temp[] = new int[m];
            Arrays.fill(temp,0);
            
            for(int j=0;j<m;j++){
                
                if(obstacleGrid[i][j]==1){
                    temp[j] = 0;
                    continue;
                }
                
                if(i==0 && j==0){
                    temp[j] = 1;
                    continue;
                }
                
                int up = 0;
                
                if(i>0){
                    up = prev[j];
                }
                
                int left = 0;
                
                if(j>0){
                    left = temp[j-1];
                }
                
                temp[j] = up+left;
            }
            
            prev = temp;
        }
        
        return prev[m-1];
    }
    
}