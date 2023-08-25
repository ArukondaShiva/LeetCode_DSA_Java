//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int node;
    int parent;
    Pair(int _node,int _parent){
        node = _node;
        parent = _parent;
    }
}

class Solution {
     
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int visited[] = new int[V];
        Arrays.fill(visited,0);
        
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(BFS(i,visited,adj)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean BFS(int src,int visited[],ArrayList<ArrayList<Integer>> adj){
        
        visited[src] = 1;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        
        while(!q.isEmpty()){
            
            Pair p = q.peek();
            q.poll();
            
            int node = p.node;
            int parent = p.parent;
            
            for(int adjNode : adj.get(node)){
                
                if(visited[adjNode]==1 && adjNode!=parent){
                    return true;
                }
                else if(visited[adjNode]==0){
                    visited[adjNode] = 1;
                    q.add(new Pair(adjNode,node));
                }
                
            } 
            
        }
        return false;
    }
    
}