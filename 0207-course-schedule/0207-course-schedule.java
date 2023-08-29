class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int r[] : prerequisites){
            adj.get(r[1]).add(r[0]);
        }
        
        int indegree[] = new int[numCourses];
        Arrays.fill(indegree,0);
        
        for(int i=0;i<numCourses;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        int count = 0;
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            count++;
            
            for(int next : adj.get(node)){
                
                indegree[next]--;
                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }
        
        
        return count==numCourses;
        
    }
    
}


















