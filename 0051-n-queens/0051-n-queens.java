class Solution {
    
    public List<List<String>> solveNQueens(int n) {
    
        List<List<String>> result = new ArrayList<>();
        char board[][] = new char[n][n];
        int leftRow[] = new int[n];
        int lowerDiagonal[] = new int[2*n-1];
        int upperDiagonal[] = new int[2*n-1];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        
        dfs(0,board,result,leftRow,lowerDiagonal,upperDiagonal,n);
        return result;
    }
    
    public void dfs(int col,char board[][], List<List<String>> result, int leftRow[],int lowerDiagonal[],int upperDiagonal[],int n){
        
        if(col==board[0].length){
            result.add(construct(board));
            return;
        }
        
        
        for(int row=0;row<board.length;row++){
            if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[(n-1)+(col-row)]==0){
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[(n-1)+(col-row)] = 1;
                board[row][col] = 'Q';
                dfs(col+1,board,result,leftRow,lowerDiagonal,upperDiagonal,n);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[(n-1)+(col-row)] = 0;
            }
        }
        
    }
    
    
    
    public List<String> construct(char board[][]){
        
        List<String> subList = new ArrayList<>();
        
        for(int r=0;r<board.length;r++){
            
            StringBuilder sb = new StringBuilder();
            
            for(int c=0;c<board[0].length;c++){
                sb.append(String.valueOf(board[r][c]));
            }
            
            subList.add(sb.toString());
        }
        
        return subList;
    }
    
    
    
}