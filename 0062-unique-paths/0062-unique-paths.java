class Solution {
    
    public int uniquePaths(int m, int n) {
        
        int dp[][] = new int[m][n];
        
        for(int r[] : dp){
            Arrays.fill(r,-1);
        }
        
        return findUniquePaths(m-1,n-1,dp);
    }
    
    public int findUniquePaths(int i,int j,int dp[][]){
        
        if(i<0 || j<0){
            return 0;
        }
        
        if(i==0 && j==0){
            return 1;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int top = findUniquePaths(i-1,j,dp);
        int left = findUniquePaths(i,j-1,dp);
            
        return dp[i][j] = top+left;
    }
    
    
}