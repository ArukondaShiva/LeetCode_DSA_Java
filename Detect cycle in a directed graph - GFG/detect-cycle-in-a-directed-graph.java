//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
         
         int visited[] = new int[V];
         int pathvis[] = new int[V];
         
         Arrays.fill(visited,0);
         Arrays.fill(pathvis,0);
         
         for(int i=0;i<V;i++){
             if(DFS(i,visited,pathvis,adj)==true){
                 return true;
             }
         }
         
         return false;
    }
    
    public boolean DFS(int node,int visited[],int pathvis[],ArrayList<ArrayList<Integer>> adj){
        
        visited[node] = 1;
        pathvis[node] = 1;
        
        for(int next : adj.get(node)){
            if(visited[next]==0){
                if(DFS(next,visited,pathvis,adj)==true){
                    return true;
                }
            }
            
            if(pathvis[next]==1){
                return true;
            }
        }
        
        pathvis[node] = 0;
        
        return false;
    }
    
}


