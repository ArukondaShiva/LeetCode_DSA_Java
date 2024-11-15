class Solution {
    
    public int uniquePaths(int m, int n) {
        
        int dp[] = new int[n];
            
        for(int i=0;i<m;i++){
            
            int temp[] = new int[n];
            
            for(int j=0;j<n;j++){
                
                if(i==0 && j==0){
                    temp[j] = 1;
                    continue;
                }
                
                int top = 0;
                if(i>0){
                    top = dp[j];
                }
                
                int bottom = 0;
                if(j>0){
                    bottom = temp[j-1];
                }
                
                temp[j] = top+bottom;
            }
            
            dp = temp;
        }
        
        return dp[n-1];
        
    }
    
     
}