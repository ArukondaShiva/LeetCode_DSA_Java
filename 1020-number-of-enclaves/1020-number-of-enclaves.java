class Solution {
    
    public int numEnclaves(int[][] grid) {
    
        int r = grid.length;
        int c = grid[0].length;
        
        int visited[][] = new int[r][c];
        
        for(int i=0;i<r;i++){
            if(grid[i][0]==1 && visited[i][0]==0){
                visited[i][0] = 1;
                DFS(i,0,grid,visited);
            }
            
            if(grid[i][c-1]==1 && visited[i][c-1]==0){
                visited[i][c-1] = 1;
                DFS(i,c-1,grid,visited);
            }
        }
        
        for(int j=0;j<c;j++){
            if(grid[0][j]==1 && visited[0][j]==0){
                visited[0][j] = 1;
                DFS(0,j,grid,visited);
            }
            if(grid[r-1][j]==1 && visited[r-1][j]==0){
                visited[r-1][j] = 1;
                DFS(r-1,j,grid,visited);
            }
        }
        
        int enclaves = 0;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    enclaves++;
                }
            }
        }
        
        return enclaves;
    }
    
    public void DFS(int row,int col,int grid[][],int visited[][]){
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        int r = grid.length;
        int c = grid[0].length;
        
        for(int i=0;i<4;i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            
            if(nrow>=0 && nrow<r && ncol>=0 && ncol<c && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                visited[nrow][ncol] = 1;
                DFS(nrow,ncol,grid,visited);
            }
            
        }
        
    }
    
    
}