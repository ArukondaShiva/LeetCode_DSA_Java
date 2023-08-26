class Solution {
    
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color,-1);
        
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(DFS(i,graph,color,0)==false){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean DFS(int src,int graph[][],int color[],int iniColor){
        
        color[src] = iniColor;
        
        for(int next : graph[src]){
            if(color[next]==-1){
                if(DFS(next,graph,color,1-iniColor)==false){
                    return false;
                }
            }
            
            if(color[next]==color[src]){
                return false;
            }
        }
        return true;
    }
    
}