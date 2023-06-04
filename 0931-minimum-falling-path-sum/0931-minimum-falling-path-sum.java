class Solution {
    public int minFallingPathSum(int[][] matrix) {
     
        int n = matrix.length;
        int m = matrix[0].length;
        
        int dp[][] = new int[n][m];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        int res = findMinPath(n,m,matrix,dp);
        return res;
    }
    
    
    public int findMinPath(int n,int m, int matrix[][],int dp[][]){
        
        int mini = Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            dp[n-1][j] = getMinPath(n-1,j,n,m,matrix,dp);
            mini = Math.min(mini,dp[n-1][j]);
        }
        return mini;
    }
    
    
    public int getMinPath(int i,int j,int n,int m,int matrix[][],int dp[][]){
        
        if(j<0 || j>=m){
            return (int)(1e9);
        }
        if(i==0){
            return matrix[i][j];
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
       
        int up = matrix[i][j] + getMinPath(i-1,j,n,m,matrix,dp);
        int left_d = matrix[i][j] + getMinPath(i-1,j-1,n,m,matrix,dp);
        int right_d = matrix[i][j] + getMinPath(i-1,j+1,n,m,matrix,dp);
        
        return dp[i][j] = Math.min(up, Math.min(left_d,right_d));
          
    }
    
    
}