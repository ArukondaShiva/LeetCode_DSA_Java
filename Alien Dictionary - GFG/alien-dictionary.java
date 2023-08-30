//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K){
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<N-1;i++){
            String w1 = dict[i];
            String w2 = dict[i+1];
            
            int len = Math.min(w1.length(),w2.length());
            
            for(int ptr=0;ptr<len;ptr++){
                if(w1.charAt(ptr)!=w2.charAt(ptr)){
                    adj.get(w1.charAt(ptr)-'a').add(w2.charAt(ptr)-'a');
                    break;
                }
            }
            
        }
        
        
        List<Integer> toporesult = new ArrayList<>();
        toposort(K,adj,toporesult);
        
        String dictOrderAlphabets = "";
        
        for(int node : toporesult){
            dictOrderAlphabets = dictOrderAlphabets+(char)(node+(int)'a');
        }
        
        return dictOrderAlphabets;
    }
    
    public void toposort(int V,ArrayList<ArrayList<Integer>> adj,List<Integer> toporesult){
        
        int indegree[] = new int[V];
        
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            toporesult.add(node);
            
            for(int next : adj.get(node)){
                indegree[next]--;
                if(indegree[next]==0){
                    q.add(next);
                }
            }
            
        }
        
    }
    
}








