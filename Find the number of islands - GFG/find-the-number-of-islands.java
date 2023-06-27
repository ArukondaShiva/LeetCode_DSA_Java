//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    
    int row;
    int col;
    
    Pair(int r,int c){
        row = r;
        col = c;
    }
}

class Solution {
     
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        int vis[][] = new int[n][m];
        
        for(int row[]:vis){
            Arrays.fill(row,0);
        }
        
        int islands = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j]=='1' && vis[i][j]==0){
                    islands++;
                    bfs(i,j,vis,grid);   
                }
                
            }
        }
        
        return islands;
    }
    
    public void bfs(int row,int col,int vis[][],char grid[][]){
        
        vis[row][col] = 1;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        
        int n = grid.length;
        int m = grid[0].length;
        
        while(!q.isEmpty()){
            
            row = q.peek().row;
            col = q.peek().col;
            q.poll();
            
            for(int r=-1;r<=1;r++){
                for(int c=-1;c<=1;c++){
                    int nrow = row+r;
                    int ncol = col+c;
                    
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                        vis[nrow][ncol] = 1;
                        bfs(nrow,ncol,vis,grid);
                    }
                    
                }
            }
            
        }
        
    }
    
    
}










