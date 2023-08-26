class Solution {
    
    public void solve(char[][] board) {
    
        int r = board.length;
        int c = board[0].length;
        
        int visited[][] = new int[r][c];
        
        for(int i=0;i<r;i++){
            
           if(board[i][0]=='O'){
               DFS(i,0,board,visited);
           }
           if(board[i][c-1]=='O'){
               DFS(i,c-1,board,visited);
           }
            
        }
        
        for(int j=0;j<c;j++){
            if(board[0][j]=='O'){
               DFS(0,j,board,visited); 
            }
            if(board[r-1][j]=='O'){
               DFS(r-1,j,board,visited);
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
    
    
    public void DFS(int row,int col,char board[][],int visited[][]){
        
        visited[row][col] = 1;
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        int r = board.length;
        int c = board[0].length;
        
        for(int i=0;i<4;i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            
            if(nrow>=0 && nrow<r && ncol>=0 && ncol<c && board[nrow][ncol]=='O' && visited[nrow][ncol]==0){
                DFS(nrow,ncol,board,visited);
            }
            
        }
        
    }
    
    
    
}