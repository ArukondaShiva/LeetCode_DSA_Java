class Pair{
    int first;
    int second;
    Pair(int _first,int _second){
        first = _first;
        second = _second;
    }
}

class tuple{
    int stops;
    int node;
    int cost;
    
    tuple(int _stops,int _node,int _cost){
        stops = _stops;
        node = _node;
        cost = _cost;
    }
}

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int r[] : flights){
            adj.get(r[0]).add(new Pair(r[1],r[2]));
        }
        
        
        int dist[] = new int[n];
        
        for(int i=0;i<n;i++){
            dist[i] = (int)(1e9);
        }
        
        dist[src] = 0;
        
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0,src,0));
        
        while(!q.isEmpty()){
            
            tuple t = q.peek();
            q.remove();
            
            int stops = t.stops;
            int cost = t.cost;
            int node = t.node;
            
            if(stops>k){
                continue;
            }
            
            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int adjCost = it.second;
                
                if(cost+adjCost < dist[adjNode]){
                    dist[adjNode] = cost+adjCost;
                    q.add(new tuple(stops+1,adjNode,cost+adjCost));
                }
            }
            
        }
        
        if(dist[dst]==(int)(1e9)){
            return -1;
        }
        
        return dist[dst];
    }
}
