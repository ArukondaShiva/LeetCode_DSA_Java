class Pair{
    int row;
    int col;
    Pair(int _row,int _col){
        row = _row;
        col = _col;
    }
}

class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int n = image.length;
        int m = image[0].length;
        
        int iniColor = image[sr][sc];
        
        int visited[][] = new int[n][m];
        
        for(int r[] : visited){
            Arrays.fill(r,0);
        }
        
        BFS(sr,sc,image,visited,color,iniColor);
        
        return image;
    }
    
    public void BFS(int sr,int sc,int image[][],int visited[][],int newColor,int iniColor){
        
        visited[sr][sc] = 1;
        image[sr][sc] = newColor;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        int n = image.length;
        int m = image[0].length;
        
        while(!q.isEmpty()){
            Pair p = q.peek();
            q.poll();
            
            int row = p.row;
            int col = p.col;
            
            for(int i=0;i<4;i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniColor && visited[nrow][ncol]==0){
                    visited[nrow][ncol] = 1;
                    image[nrow][ncol] = newColor;
                    q.add(new Pair(nrow,ncol));
                }
                
            }
            
        }
        
    }
}