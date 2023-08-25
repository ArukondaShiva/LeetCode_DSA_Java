class Pair{
    int row;
    int col;
    Pair(int _row,int _col){
        row = _row;
        col = _col;
    }
}

class Solution {
    
    public int orangesRotting(int[][] grid) {
    
        if(grid.length==0 || grid==null){
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        
        int totalOranges = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                if(grid[i][j]!=0){
                    totalOranges++;
                }
            }
        }
        
        int minutes = 0;
        int count = 0;
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        while(!q.isEmpty()){
            
            int size = q.size();
            count += size;
            
            for(int s=0;s<size;s++){
                
                Pair p = q.peek();
                q.poll();
                
                int row = p.row;
                int col = p.col;
                
                for(int i=0;i<4;i++){
                    int nrow = row+delrow[i];
                    int ncol = col+delcol[i];
                    
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                        grid[nrow][ncol] = 2;
                        q.add(new Pair(nrow,ncol));
                    }
                    
                }
                
            }
            
            if(q.size()!=0){
                minutes++;
            }
            
        }
        
        return count==totalOranges ? minutes : -1;
    }
    
    
}











