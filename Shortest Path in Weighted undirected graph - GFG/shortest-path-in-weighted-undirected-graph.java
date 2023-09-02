//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int first;
    int second;
    Pair(int _first,int _second){
        first = _first;
        second = _second;
    }
}

class Solution {
    
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
       
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
       
       for(int i=0;i<n+1;i++){
           adj.add(new ArrayList<Pair>());
       }
       
       for(int r[] : edges){
           adj.get(r[0]).add(new Pair(r[1],r[2]));
           adj.get(r[1]).add(new Pair(r[0],r[2]));
       }
          
       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.first-b.first);
       
       int dist[] = new int[n+1];
       int parent[] = new int[n+1];
       
       for(int i=0;i<=n;i++){
           parent[i] = i;
           dist[i] = (int)(1e9);
       }
       
       dist[1] = 0;
       pq.add(new Pair(0,1));
       
       while(!pq.isEmpty()){
           
           Pair p = pq.peek();
           pq.remove();
           
           int node = p.second;
           int distance = p.first;
           
           for(Pair it : adj.get(node)){
               
               int adjNode = it.first;
               int edgeWeight = it.second;
               
               if(distance+edgeWeight <dist[adjNode]){
                   dist[adjNode] = distance+edgeWeight;
                   parent[adjNode] = node;
                   pq.add(new Pair(dist[adjNode],adjNode));
               }
               
           }
       }
       
       List<Integer> path = new ArrayList<>();
       
       if(dist[n]==(int)(1e9)){
           path.add(-1);
           return path;
       }
       
       int node = n;
       path.add(node);
       
       while(parent[node]!=node){
           path.add(parent[node]);
           node = parent[node];
       }
    
       Collections.reverse(path);
       
       return path;
    }
    
}












