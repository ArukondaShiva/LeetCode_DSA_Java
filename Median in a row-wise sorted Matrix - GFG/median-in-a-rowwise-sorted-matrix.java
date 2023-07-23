//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    int median(int matrix[][], int R, int C) {
      
      int N = R*C;
      
      //1 <= matrix[i][j] <= 2000 (given in Question)
      int start = 1;
      int end = 2000;
      
      while(start<=end){
          
          int mid = (start+end)/2;
          
          //finding no of elements lesser than mid in matrix.
          int smallerElements = findSmallerElements(matrix,mid);
          
          //if <=N/2 , median lies in the right half - else left half
          if(smallerElements<=N/2){
              start = mid+1;
          }
          else{
              end = mid-1;
          }
      }
      
      return start;        
    }
    
    int findSmallerElements(int matrix[][],int mid){
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int count = 0;
        
        for(int r[] : matrix){
            count+= binarySearch(r,mid);
        }
        
        return count;
    }
    
    int binarySearch(int arr[],int target){
         int n = arr.length;
         
         int low = 0;
         int high = n-1;
         
         while(low<=high){
             int mid = (low+high)/2;
             if(arr[mid]<=target){
                 low = mid+1;
             }
             else{
                 high = mid-1;
             }
         }
         return low;
    }
    
}









