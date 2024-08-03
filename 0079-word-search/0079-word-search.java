class Solution {
    
    public boolean exist(char[][] board, String word) {
    
        int r = board.length;
        int c = board[0].length;
        
        boolean visited[][] = new boolean[r][c];
        
        for(boolean rarr[] : visited){
            Arrays.fill(rarr,false);
        }
        
        int n = word.length();
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(word.charAt(0)==board[i][j]){
                    if(findRec(1,i,j,word,board,visited)==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean findRec(int ind,int row,int col,String word,char board[][],boolean visited[][]){
        
        if(ind==word.length()){
            return true;
        }
        
        int r = board.length;
        int c = board[0].length;
        
        visited[row][col] = true;
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        for(int i=0;i<4;i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            
            if(nrow>=0 && nrow<r && ncol>=0 && ncol<c && board[nrow][ncol]==word.charAt(ind) &&visited[nrow][ncol]==false){
                 if(findRec(ind+1,nrow,ncol,word,board,visited)==true){
                     return true;
                 }
            }
            
        }
        
        visited[row][col] = false;
        
        return false;
    }
    
    
    
}








