class Pair{
    int row;
    int col;
    Pair(int _row,int _col){
        row = _row;
        col = _col;
    }
}

class Solution {
    
    public int numEnclaves(int[][] grid) {
    
        int r = grid.length;
        int c = grid[0].length;
        
        int visited[][] = new int[r][c];
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<r;i++){
            if(grid[i][0]==1){
                visited[i][0] = 1;
                q.add(new Pair(i,0));
            }
            if(grid[i][c-1]==1){
                visited[i][c-1] = 1;
                q.add(new Pair(i,c-1));
            }
        }
        
        for(int j=0;j<c;j++){
            if(grid[0][j]==1){
                visited[0][j] = 1;
                q.add(new Pair(0,j));
            }
            if(grid[r-1][j]==1){
                visited[r-1][j] = 1;
                q.add(new Pair(r-1,j));
            }
        }
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        while(!q.isEmpty()){
            
            Pair p = q.peek();
            q.poll();
            
            int row = p.row;
            int col = p.col;
            
            for(int i=0;i<4;i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                
                if(nrow>=0 && nrow<r && ncol>=0 && ncol<c && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    visited[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol));
                }
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
    
}