//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Pair{
    int next;
    int weight;
    Pair(int _next,int _weight){
        next = _next;
        weight = _weight;
    }
}

class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
	    
	   ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	   
	   for(int i=0;i<N;i++){
	       adj.add(new ArrayList<Pair>());
	   }
	   
	   for(int r[] : edges){
	       adj.get(r[0]).add(new Pair(r[1],r[2]));
	   }
	
	   int visited[] = new int[N];
	   Arrays.fill(visited,0);
	   
	   Stack<Integer> st = new Stack<>();
	
	   for(int i=0;i<N;i++){
	       if(visited[i]==0){
	           DFS(i,visited,adj,st);
	       }
	   }
	   
	   int distance[] = new int[N];
	   
	   for(int i=0;i<N;i++){
	       distance[i] = (int)(1e9);
	   }
	   
	   distance[0] = 0;
	   
	   while(!st.isEmpty()){
	       int node = st.pop();
	       
	       for(int i=0;i<adj.get(node).size();i++){
	           int v = adj.get(node).get(i).next;
	           int wt = adj.get(node).get(i).weight;
	           
	           if(distance[node]+wt < distance[v]){
	               distance[v] = distance[node]+wt;
	           }
	       }
	   }
	   
	   for(int i=0;i<N;i++){
	       if(distance[i]==(int)(1e9)){
	           distance[i] = -1;
	       }
	   }
		
	   return distance; 
	}
	
	public void DFS(int node,int visited[],ArrayList<ArrayList<Pair>> adj,Stack<Integer> st){
	    
	    visited[node] = 1;
	    
	    for(int i=0;i<adj.get(node).size();i++){
	        int next = adj.get(node).get(i).next;
	        if(visited[next]==0){
	            DFS(next,visited,adj,st);
	        }
	    }
	    
	    st.add(node);
	}
	
	
	
}






