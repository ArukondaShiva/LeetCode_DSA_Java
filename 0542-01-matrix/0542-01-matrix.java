class Pair{
    int row;
    int col;
    int dist;
    Pair(int _row,int _col,int _dist){
        row = _row;
        col = _col;
        dist = _dist;
    }
}

class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
    
        int r = mat.length;
        int c = mat[0].length;
        
        int visited[][] = new int[r][c];
        int distance[][] = new int[r][c];
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==0){
                    visited[i][j] = 1;
                    q.add(new Pair(i,j,0));
                }
                
            }
        }
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        while(!q.isEmpty()){
            Pair p = q.peek();
            q.poll();
            
            int row = p.row;
            int col = p.col;
            int dist = p.dist;
            
            distance[row][col] = dist;
            
            for(int i=0;i<4;i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                
                if(nrow>=0 && nrow<r && ncol>=0 && ncol<c && visited[nrow][ncol]==0){
                    visited[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol,dist+1));
                }
                
            }
            
        }
        
        return distance;
    }
    
}








