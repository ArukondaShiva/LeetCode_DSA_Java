class Solution {
    
    public int minCut(String s) {
    
        int n = s.length();
        int i = 0;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return findMinCut(i,n,s,dp)-1;
    }
    
    public int findMinCut(int i,int n,String s,int dp[]){
        
        if(i==n){
            return 0;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
        
        int minCuts = Integer.MAX_VALUE;
        
        for(int j=i;j<n;j++){    
            if(isPalindrome(i,j,s)){
                int cuts =1+findMinCut(j+1,n,s,dp);
                minCuts = Math.min(minCuts,cuts);
            }
        }
        
        return dp[i] = minCuts;
    }
    
    public boolean isPalindrome(int i,int j,String s){
        while(i<=j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    
}