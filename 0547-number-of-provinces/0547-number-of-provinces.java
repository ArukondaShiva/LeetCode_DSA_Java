class Solution {
    
    public int findCircleNum(int[][] isConnected) {
    
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    adjList.get(i+1).add(j+1);
                    adjList.get(j+1).add(i+1);
                }
            }
        }
        
        
        int visited[] = new int[n+1];
        Arrays.fill(visited,0);
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int provinces = 0;
        
        for(int i=1;i<=n;i++){
            if(visited[i]==0){
                BFS(i,visited,list,adjList);
                provinces++;
            }
        }
        
        return provinces;
    }
    
    public void BFS(int src,int visited[],ArrayList<Integer> list,ArrayList<ArrayList<Integer>> adjList){
        
        Queue<Integer> q = new LinkedList<>();
        visited[src] = 1;
        q.add(src);
        
        while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);
            
            for(int adjNode : adjList.get(node)){
                
                if(visited[adjNode]==0){
                    visited[adjNode] = 1;
                    q.add(adjNode);
                }
                
            }
            
        }
        
    }
    
}



