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
                if(DFS(i,-1,visited,adj)==true){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean DFS(int node,int parent,int visited[],ArrayList<ArrayList<Integer>> adj){
        
        visited[node] = 1;
        
        for(int adjNode : adj.get(node)){
            
            if(visited[adjNode]==0){
                if(DFS(adjNode,node,visited,adj)){
                    return true;
                }
            }
            else if(visited[adjNode]==1 && adjNode!=parent){
                return true;
            }
        }
     
        return false;    
    }
    
}