class Solution {
    
    public int fib(int n) {
        
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return findFibonacci(n,dp);
    }
    
    public int findFibonacci(int n,int dp[]){
        
        if(n<=1){
            return n;
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        
        return dp[n] = findFibonacci(n-1,dp)+findFibonacci(n-2,dp);
    }
    
}