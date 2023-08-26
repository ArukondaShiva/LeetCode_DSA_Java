//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
         
         int n = grid.length;
         int m = grid[0].length;
         
         int visited[][] = new int[n][m];
         
         HashSet<ArrayList<String>> hs = new HashSet<>();
         
         for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                 if(grid[i][j]==1 && visited[i][j]==0){
                     ArrayList<String> list = new ArrayList<>();
                     DFS(i,j,grid,visited,list,i,j);
                     hs.add(list);
                 }
             }
         }
         
         return hs.size();
    }
    
    void DFS(int row,int col,int grid[][],int visited[][],ArrayList<String> list,int row0,int col0){
        
        visited[row][col] = 1;
        
        list.add(toString(row,col,row0,col0));
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i<4;i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
              DFS(nrow,ncol,grid,visited,list,row0,col0);   
            }
        }
    }
    
    String toString(int row,int col,int row0,int col0){
        return Integer.toString(row-row0)+" "+Integer.toString(col-col0);
    }
    
}












