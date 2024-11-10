class Pair{
    int distance;
    int x2;
    int y2;
    Pair(int distance,int x2,int y2){
        this.distance = distance;
        this.x2 = x2;
        this.y2 = y2;
    }
}

class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.distance-a.distance);
        
        int n = points.length;
        
        for(int i=0;i<n;i++){
            
            int x2 = points[i][0];
            int y2 = points[i][1];
            int distance = findDistance(0,0,x2,y2);
            
            if(pq.size()<k){
                pq.add(new Pair(distance,x2,y2));
            }else{
                if(pq.peek().distance > distance){
                    pq.poll();
                    pq.add(new Pair(distance,x2,y2));
                }
            }
            
        }
        
        int result[][] = new int[pq.size()][2];
        int i = 0;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            result[i++]= new int[]{p.x2,p.y2};
        }
        
        return result;
    }
    
    public int findDistance(int x1,int y1,int x2,int y2){
        //return (int)Math.sqrt((double)Math.pow(x1-y1,2)+(double)Math.pow(y1-y2,2));
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }
    
    
}