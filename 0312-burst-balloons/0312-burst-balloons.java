class Solution {
    
    public int maxCoins(int[] nums) {
    
        int len = nums.length;
        
        int arr[] = new int[len+2];
        arr[0] = 1;
        for(int i=0;i<len;i++){
            arr[i+1] = nums[i];
        }
        arr[len+1]=1;
        
        int n = arr.length;
        
        int dp[][] = new int[n][n];
        
        for(int r[]: dp){
            Arrays.fill(r,-1);
        }
        
        return burst_balloon(1,n-2,arr,dp);
        
    }
    
    
    public int burst_balloon(int i,int j,int arr[],int dp[][]){
        
        if(i>j){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int mini = Integer.MIN_VALUE;
        
        for(int ind=i;ind<=j;ind++){
            int points = (arr[i-1]*arr[ind]*arr[j+1])+burst_balloon(i,ind-1,arr,dp)+burst_balloon(ind+1,j,arr,dp);
            mini = Math.max(mini,points);
        }
        
        return dp[i][j] = mini;
    }
    
}