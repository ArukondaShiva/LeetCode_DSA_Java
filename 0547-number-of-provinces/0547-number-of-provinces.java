class Solution {
    
    public int findCircleNum(int[][] isConnected) {
    
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        int n = isConnected.length;
        
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                  adjList.get(i+1).add(j+1);
                  adjList.get(j+1).add(i+1);   
                }
            }
        }
        
        boolean visited[] = new boolean[n+1];
        Arrays.fill(visited,false);
        
        int provinces = 0;
        
        for(int i=1;i<=n;i++){
            if(visited[i]==false){
                provinces++;
                dfs(i,visited,adjList);
            }
        }
        
        return provinces;
    }
    
    
    public void dfs(int node,boolean visited[],ArrayList<ArrayList<Integer>> adjList){
        
        visited[node] = true;
        
        for(Integer it : adjList.get(node)){
            if(visited[it]==false){
                dfs(it,visited,adjList);
            }
        }
        
    }
    
    
}