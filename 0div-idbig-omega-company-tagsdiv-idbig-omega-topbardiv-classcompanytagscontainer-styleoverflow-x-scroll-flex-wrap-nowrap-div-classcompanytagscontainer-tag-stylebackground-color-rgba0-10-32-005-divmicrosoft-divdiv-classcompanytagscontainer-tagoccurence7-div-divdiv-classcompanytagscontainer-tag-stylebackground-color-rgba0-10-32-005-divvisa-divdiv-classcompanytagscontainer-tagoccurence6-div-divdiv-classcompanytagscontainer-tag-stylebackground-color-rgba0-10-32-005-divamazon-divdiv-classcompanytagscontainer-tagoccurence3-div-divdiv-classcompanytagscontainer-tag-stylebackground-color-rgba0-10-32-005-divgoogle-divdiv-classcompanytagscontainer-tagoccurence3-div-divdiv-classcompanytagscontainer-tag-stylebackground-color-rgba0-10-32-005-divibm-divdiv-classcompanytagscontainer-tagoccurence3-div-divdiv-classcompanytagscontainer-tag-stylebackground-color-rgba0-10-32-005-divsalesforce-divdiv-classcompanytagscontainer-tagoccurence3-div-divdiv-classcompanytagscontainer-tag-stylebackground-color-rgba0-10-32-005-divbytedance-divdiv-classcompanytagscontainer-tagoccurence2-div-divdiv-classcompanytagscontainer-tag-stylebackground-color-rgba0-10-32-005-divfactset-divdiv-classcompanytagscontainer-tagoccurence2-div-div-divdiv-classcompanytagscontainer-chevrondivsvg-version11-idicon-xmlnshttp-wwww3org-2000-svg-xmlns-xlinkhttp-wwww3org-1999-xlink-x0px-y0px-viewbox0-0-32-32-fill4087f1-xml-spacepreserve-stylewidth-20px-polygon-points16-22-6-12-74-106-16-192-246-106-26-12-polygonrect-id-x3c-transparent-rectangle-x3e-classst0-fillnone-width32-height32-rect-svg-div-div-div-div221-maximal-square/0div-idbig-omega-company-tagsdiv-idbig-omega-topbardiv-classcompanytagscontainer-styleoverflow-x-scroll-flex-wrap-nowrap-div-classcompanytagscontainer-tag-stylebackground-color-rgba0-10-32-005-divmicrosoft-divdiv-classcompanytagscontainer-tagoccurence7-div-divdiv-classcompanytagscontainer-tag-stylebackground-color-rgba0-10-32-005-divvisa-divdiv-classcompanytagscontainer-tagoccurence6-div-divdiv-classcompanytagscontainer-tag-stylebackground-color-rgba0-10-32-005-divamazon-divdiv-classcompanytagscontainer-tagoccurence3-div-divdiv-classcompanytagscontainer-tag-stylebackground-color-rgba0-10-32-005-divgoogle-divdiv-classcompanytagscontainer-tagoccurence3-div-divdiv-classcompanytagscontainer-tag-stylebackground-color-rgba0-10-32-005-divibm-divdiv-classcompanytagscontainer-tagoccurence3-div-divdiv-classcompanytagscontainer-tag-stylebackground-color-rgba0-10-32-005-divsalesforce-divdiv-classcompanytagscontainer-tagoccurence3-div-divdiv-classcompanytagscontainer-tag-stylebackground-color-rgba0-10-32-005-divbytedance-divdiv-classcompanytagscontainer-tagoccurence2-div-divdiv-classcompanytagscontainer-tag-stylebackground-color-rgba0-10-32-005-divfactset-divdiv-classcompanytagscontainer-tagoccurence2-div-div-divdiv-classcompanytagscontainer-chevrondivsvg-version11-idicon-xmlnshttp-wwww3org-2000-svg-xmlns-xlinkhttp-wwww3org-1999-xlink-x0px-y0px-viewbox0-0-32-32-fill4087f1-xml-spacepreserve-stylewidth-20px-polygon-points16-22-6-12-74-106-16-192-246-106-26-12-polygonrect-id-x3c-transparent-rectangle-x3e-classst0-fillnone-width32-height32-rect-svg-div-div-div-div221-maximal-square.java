class Solution {
    
    public int maximalSquare(char[][] matrix) {
    
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int dp[][] = new int[rows][cols];
        
        int maxSide = 0;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0 || j==0 || matrix[i][j]=='0'){
                    dp[i][j] = matrix[i][j]-'0';
                }
                else{
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
                
                maxSide = Math.max(maxSide,dp[i][j]);
            }
        }
        
        return maxSide*maxSide;
    }
    
}