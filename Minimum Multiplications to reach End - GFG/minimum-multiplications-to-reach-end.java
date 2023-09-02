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
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
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
    
    int minimumMultiplications(int[] arr, int start, int end) {

       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.first-b.first);
       pq.add(new Pair(0,start));
       
       int mod = 100000;
       
       int dist[] = new int[100000];
       
       for(int i=0;i<100000;i++){
           dist[i] = (int)(1e9);
       }
       
       while(!pq.isEmpty()){
           Pair p = pq.peek();
           pq.remove();
           int steps = p.first;
           int node = p.second;
           
           if(node==end){
               return steps;
           }
           
           for(int i=0;i<arr.length;i++){
               int num = (node*arr[i])%mod;
               if(steps+1<dist[num]){
                 dist[num] = steps+1;
                 pq.add(new Pair(steps+1,num));   
               }
           }
       }
      
       return -1;
    }
    
}
