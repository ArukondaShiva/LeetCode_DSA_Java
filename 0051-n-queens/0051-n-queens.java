class Solution {
    
    public List<List<String>> solveNQueens(int n) {
    
        List<List<String>> result = new ArrayList<>();
        char board[][] = new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        
        dfs(0,board,result);
        return result;
    }
    
    public void dfs(int col,char board[][], List<List<String>> result){
        
        if(col==board[0].length){
            result.add(construct(board));
            return;
        }
        
        
        for(int row=0;row<board.length;row++){
            if(isValidate(row,col,board)){
                board[row][col] = 'Q';
                dfs(col+1,board,result);
                board[row][col] = '.';
            }
        }
        
    }
    
    public boolean isValidate(int row,int col,char board[][]){
       
        int n = board.length;
        
        // column check
        int duprow = row;
        int dupcol = col;
        
        while(dupcol>=0){
            if(board[duprow][dupcol]=='Q'){
                return false;
            }
            dupcol--;
        }
        
        // diagonal check
        duprow = row;
        dupcol = col;
        
        while(duprow>=0 && dupcol>=0){
            if(board[duprow][dupcol]=='Q'){
                return false;
            }
            duprow--;
            dupcol--;
        }
        
        duprow = row;
        dupcol = col;
        
        while(duprow<n && dupcol>=0){
            if(board[duprow][dupcol]=='Q'){
                return false;
            }
            duprow++;
            dupcol--;
        }
    
       return true;
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