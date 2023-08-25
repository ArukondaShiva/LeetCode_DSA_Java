class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    
        int n = image.length;
        int m = image[0].length;
        
        int iniColor = image[sr][sc];
        
        int visited[][] = new int[n][m];
        
        for(int r[] : visited){
            Arrays.fill(r,0);
        }
        
        DFS(sr,sc,image,visited,iniColor,color);
        
        return image;
    }
    
    public void DFS(int row,int col,int image[][],int visited[][],int iniColor,int newColor){
        
        visited[row][col] = 1;
        image[row][col] = newColor;
        
        int n = image.length;
        int m = image[0].length;
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        for(int i=0;i<4;i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniColor && visited[nrow][ncol]==0){
                DFS(nrow,ncol,image,visited,iniColor,newColor);
            }
        }
        
    }
    
}