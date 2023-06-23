class Solution {
    
    public int minCost(int n, int[] cuts) {
    
        int len = cuts.length;
        int arr[]=new int[len+2];
        
        arr[0] = 0;
        for(int i=0;i<len;i++){
            arr[i+1] = cuts[i];
        }
        arr[len+1] = n;
        
        Arrays.sort(arr);
        
        int dp[][] = new int[arr.length][arr.length];
        
        for(int r[]:dp){
            Arrays.fill(r,-1);
        }

        return findCost(1,arr.length-2,arr,dp);
        
    }
    
    public int findCost(int i,int j,int arr[],int dp[][]){
        
        if(i>j){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int mini = (int)(1e9);
        
        for(int ind=i;ind<=j;ind++){
            int cost = (arr[j+1]-arr[i-1])+findCost(i,ind-1,arr,dp)+findCost(ind+1,j,arr,dp);
            mini = Math.min(mini,cost);
        }
        
        return dp[i][j] = mini;
    }
    
}