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
    // Function to detect cycle in an undirected graph.
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean visited[] = new boolean[V];
        Arrays.fill(visited,false);

        for(int sr=0;sr<V;sr++){
            if(visited[sr]==false){
              if(checkForCycle(sr,adj,visited)==true){
                 return true;
              }   
            }
        }
        
        return false;
    }
    
    public boolean checkForCycle(int src,ArrayList<ArrayList<Integer>> adj,boolean visited[]){
        
        visited[src] = true;
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(src,-1));
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
            
               int node = q.peek().node;
               int parent = q.peek().parent;
               q.poll();
               
               for(Integer adjNode : adj.get(node)){
                   if(visited[adjNode]==false){
                       visited[adjNode]=true;
                       q.add(new Pair(adjNode,node));
                   }
                   else if(visited[adjNode]==true && parent!=adjNode){
                       return true;
                   }
               }
            
            }
        }
        
        return false;
    }
    
}