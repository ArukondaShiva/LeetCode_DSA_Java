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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class tuple{
    int distance;
    int row;
    int col;
    tuple(int _distance,int _row,int _col){
        distance = _distance;
        row = _row;
        col = _col;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

       int n = grid.length;
       int m = grid[0].length;
       
       int dist[][] = new int[n][m];
       
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               dist[i][j] = (int)(1e9);
           }
       }
       
       PriorityQueue<tuple> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
       pq.add(new tuple(0,source[0],source[1]));
       dist[source[0]][source[1]] = 0;
       
       int delrow[] = {-1,0,+1,0};
       int delcol[] = {0,+1,0,-1};
       
       while(!pq.isEmpty()){
          
          tuple t = pq.peek();
          pq.remove();
          
          int row = t.row;
          int col = t.col;
          int distance = t.distance;
          
          if(row==destination[0] && col==destination[1]){
              return distance;
          }
          
          for(int i=0;i<4;i++){
              int nrow = row+delrow[i];
              int ncol = col+delcol[i];
              
              if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && distance+1 < dist[nrow][ncol]){
                  dist[nrow][ncol] = distance+1;
                  pq.add(new tuple(distance+1,nrow,ncol));
              }
              
          }
             
       }
       
       return -1;
       
    }
}






