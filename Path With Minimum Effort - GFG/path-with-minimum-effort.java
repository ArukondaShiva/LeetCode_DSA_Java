//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

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
    
    int MinimumEffort(int heights[][]) {
        
        int n = heights.length;
        int m = heights[0].length;
        
        int dist[][] = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)(1e9);
            }
        }
        
        PriorityQueue<tuple> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.add(new tuple(0,0,0));
        dist[0][0] = 0;
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        while(!pq.isEmpty()){
            tuple t = pq.peek();
            pq.remove();
            
            int distance = t.distance;
            int row = t.row;
            int col = t.col;
            
            if(row==n-1 && col==m-1){
                return distance;
            }
            
            for(int i=0;i<4;i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    
                    int maxEffort = Math.max(Math.abs(heights[row][col]-heights[nrow][ncol]),distance);
                    
                    if(maxEffort<dist[nrow][ncol]){
                        dist[nrow][ncol] = maxEffort;
                        pq.add(new tuple(maxEffort,nrow,ncol));
                    }
                    
                }  
            }
            
        }
        
        return 0;
    }
    
}




