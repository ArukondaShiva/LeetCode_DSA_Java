//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        int visited[] = new int[V];
        int pathvis[] = new int[V];
        int check[] = new int[V];
        
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,visited,pathvis,check,adj);
            }
        }
        
        ArrayList<Integer> safeNodes = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(check[i]==1){
                safeNodes.add(i);
            }
        }
        
        return safeNodes;
    }
    
    
    boolean dfs(int node,int visited[],int pathvis[],int check[],List<List<Integer>> adj){
        
        visited[node] = 1;
        pathvis[node] = 1;
        
        for(int next : adj.get(node)){
            
            if(visited[next]==0){
                if(dfs(next,visited,pathvis,check,adj)==true){
                    return true;
                }
            }
            if(pathvis[next]==1){
                return true;
            }
        }
        
        pathvis[node] = 0;
        check[node] = 1;
        
        return false;
    }
    
    
}



