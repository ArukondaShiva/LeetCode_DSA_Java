

class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int n=s.length();
         int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
         return findLCS(n,m,s,t,dp);
    }

     public static int findLCS(int ind1,int ind2,String s,String t,int dp[][]){
        if(ind1==0 || ind2==0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        
        if(s.charAt(ind1-1)==t.charAt(ind2-1)){
            return dp[ind1][ind2]=1+findLCS(ind1-1,ind2-1,s,t,dp);
        }else{
            return dp[ind1][ind2]=0+Math.max(findLCS(ind1-1,ind2,s,t,dp),findLCS(ind1,ind2-1,s,t,dp));
        }
        
    }


}







