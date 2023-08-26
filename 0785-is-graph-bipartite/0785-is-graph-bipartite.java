class Solution {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int color[] = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (BFS(i, graph, color) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean BFS(int src,int graph[][],int color[]) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int next : graph[node]){
                if(color[next]==-1){
                    color[next] = 1-color[node];
                    q.add(next);
                }
                
                if(color[next]==color[node]){
                    return false;
                }
            }
            
        }
        
        return true;
    }
}
