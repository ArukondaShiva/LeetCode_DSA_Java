class Solution {
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
    
        int V = graph.length;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<V;i++){
            for(int it : graph[i]){
                adj.get(it).add(i);
            }
        }
        
        int indegree[] = new int[V];
        
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            safeNodes.add(node);
            
            for(int next : adj.get(node)){
                indegree[next]--;
                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }
        
        Collections.sort(safeNodes);
        
        return safeNodes;
    }
    
}