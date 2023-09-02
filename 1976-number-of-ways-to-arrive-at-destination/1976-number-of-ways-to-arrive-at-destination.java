class Pair {
    long first;
    long second;

    Pair(long _first, long _second) {
        first = _first;
        second = _second;
    }
}

class Solution {

    public int countPaths(int n, int[][] roads) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        
        long dist[] = new long[n];
        long ways[] = new long[n];
        
        for(int i=0;i<n;i++){
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        
        int mod = (int)(1e9+7);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.first, b.first));
        pq.add(new Pair(0,0));
        dist[0] = 0;
        ways[0] = 1;
        
        while(!pq.isEmpty()){
            
            Pair p = pq.peek();
            pq.remove();
            
            long time = p.first;
            long node = p.second;
            
            for(Pair it : adj.get((int)node)){
                
                long edgeTime = it.second;
                long adjNode = it.first;
                
                if(time+edgeTime < dist[(int)adjNode]){
                    pq.add(new Pair(time+edgeTime, (int)adjNode));
                    dist[(int)adjNode] = time+edgeTime;
                    ways[(int)adjNode] = ways[(int)node];
                }
                
                else if(time+edgeTime == dist[(int)adjNode]){
                    ways[(int)adjNode] = (ways[(int)node]+ways[(int)adjNode])%mod;
                }
            }
            
        }
        
        return (int)(ways[n-1]%mod);
    }
    
}











