class Pair{
    int row;
    int col;
    Pair(int _row,int _col){
        row = _row;
        col = _col;
    }
}

class Solution {
    
    public void solve(char[][] board) {
       
        int r = board.length;
        int c = board[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        
        int visited[][] = new int[r][c];
        
        for(int i=0;i<r;i++){
            if(board[i][0]=='O'){
                visited[i][0] = 1;
                q.add(new Pair(i,0));
            }
            if(board[i][c-1]=='O'){
                visited[i][c-1] = 1;
                q.add(new Pair(i,c-1));
            }
        }
        
        for(int j=0;j<c;j++){
            if(board[0][j]=='O'){
                visited[0][j] = 1;
                q.add(new Pair(0,j));
            }
            if(board[r-1][j]=='O'){
                visited[r-1][j] = 1;
                q.add(new Pair(r-1,j));
            }
        }
        
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        while(!q.isEmpty()){
            
            Pair p = q.peek();
            q.remove();
            
            int row = p.row;
            int col = p.col;
            
            for(int i=0;i<4;i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                
                if(nrow>=0 && nrow<r && ncol>=0 && ncol<c && board[nrow][ncol]=='O' && visited[nrow][ncol]==0){
                    visited[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol));
                }
                
            }
            
        }
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                    board[i][j] = 'X';
                }
            }
        }
      
    }
}