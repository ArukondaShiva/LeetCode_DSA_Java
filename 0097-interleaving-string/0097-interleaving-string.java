class Solution {
    
    public boolean isInterleave(String s1, String s2, String s3) {
    
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        
        boolean dp[][][] = new boolean[n1+1][n2+1][n3+1];
        
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                for(int k=0;k<=n3;k++){
                    dp[i][j][k] = false;
                }
            }
        }
        
        dp[n1][n2][n3] = true;
        
        for(int i=n1;i>=0;i--){
            for(int j=n2;j>=0;j--){
                for(int k=n3;k>=0;k--){
                    if(i<n1 && j<n2 && k<n3 && s1.charAt(i)==s3.charAt(k) && s2.charAt(j)==s3.charAt(k)){
                        dp[i][j][k] = dp[i+1][j][k+1] || dp[i][j+1][k+1];
                    }
                    else if(i<n1 && k<n3 && s1.charAt(i)==s3.charAt(k)){
                        dp[i][j][k] = dp[i+1][j][k+1];
                    }
                    else if(j<n2 && k<n3 && s2.charAt(j)==s3.charAt(k)){
                        dp[i][j][k] = dp[i][j+1][k+1];
                    }
                }
            }
        }
        
        return dp[0][0][0];
    }
    
}