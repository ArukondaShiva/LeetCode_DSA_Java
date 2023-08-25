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
    Pair(int _row,int _col){
        row = _row;
        col = _col;
    }
}


class Solution {
    // Function to find the number of islands.
    
    public int numIslands(char[][] grid) {
    
        int n = grid.length;
        int m = grid[0].length;
        
        int visited[][] = new int[n][m];
        
        
        for(int r[]: visited){
            Arrays.fill(r,0);
        }
        
        int islands = 0;
       
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              if(grid[i][j]=='1' && visited[i][j]==0){
                  DFS(i,j,grid,visited);
                  islands++;
              }
            }
        }
        
        return islands;
    }
    
    public void DFS(int row,int col,char grid[][],int vis[][]){
        
         Queue<Pair> q = new LinkedList<>();
         q.add(new Pair(row,col));
         
         int n = grid.length;
         int m = grid[0].length;
         
         while(!q.isEmpty()){
             Pair p = q.peek();
             q.poll();
             
             row = p.row;
             col = p.col;
             
             for(int r=-1;r<=1;r++){
                 for(int c=-1;c<=1;c++){
                     int nrow = row+r;
                     int ncol = col+c;
                     if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                         vis[nrow][ncol] = 1;
                         q.add(new Pair(nrow,ncol));
                     }
                 }
             }
             
         }
        
    }
    
}


