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
    
    public int minimumEffortPath(int[][] heights) {
    
        int n = heights.length;
        int m = heights[0].length;
        
        int dist[][] = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)(1e9);
            }
        }
        
        PriorityQueue<tuple> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        dist[0][0] = 0;
     
        pq.add(new tuple(0,0,0));
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        while(!pq.isEmpty()){
            
            tuple t = pq.peek();
            pq.remove();
            
            int row = t.row;
            int col = t.col;
            int distance = t.distance;
            
            if(row==n-1 && col==m-1){
                return distance;
            }
            
            for(int i=0;i<4;i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    
                    int maxEffort = Math.max(Math.abs(heights[nrow][ncol]-heights[row][col]),distance);
                    
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




