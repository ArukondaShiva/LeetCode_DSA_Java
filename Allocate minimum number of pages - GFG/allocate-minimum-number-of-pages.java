//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M){
        
        if(N<M){
            return -1;
        }
        
        int totalPages = 0;
        int low = 0;
        
        for(int pages : A){
            low = Math.max(low,pages);
            totalPages += pages;
        }
        
        int high = totalPages;
        
        int ans = -1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canAllocationPossible(A,mid,M)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return ans;
    }
    
    public static boolean canAllocationPossible(int arr[],int maxPages,int students){
        
         int studentCount = 1;
         int pageCount = 0;
         
         for(int i=0;i<arr.length;i++){
             
             pageCount = pageCount+arr[i];
             
             if(pageCount>maxPages){
                 studentCount++;
                 pageCount = arr[i];
             }
             
         }
         
         return studentCount<=students;
    }
    
};



















