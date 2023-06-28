class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int iniColor = image[sr][sc];
        
        int n = image.length;
        int m = image[0].length;
        
        int ans[][] = image;
        int vis[][] = new int[n][m];
        
        for(int row[] : vis){
            Arrays.fill(row,0);
        }
        
        DFS(sr,sc,iniColor,color,ans,vis);
            
        return ans;
    }
    
    public void DFS(int row,int col,int iniColor,int color,int ans[][],int vis[][]){
        
        vis[row][col] = 1;
        ans[row][col] = color;
        
        int n = ans.length;
        int m = ans[0].length;
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        for(int i=0;i<4;i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]==iniColor && vis[nrow][ncol]==0){
                DFS(nrow,ncol,iniColor,color,ans,vis);
            }
            
        }
        
    }
    
}