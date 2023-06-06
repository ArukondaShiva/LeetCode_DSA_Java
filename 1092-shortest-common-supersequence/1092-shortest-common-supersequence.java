class Solution {
    
    public String shortestCommonSupersequence(String str1, String str2) {
    
        int n1 = str1.length();
        int n2 = str2.length();
        return findSCS(str1,str2,n1,n2);
        
    }
    
    public String findSCS(String s1,String s2,int n1,int n2){
        
        int dp[][] = new int[n1+1][n2+1];
        
        for(int i=0;i<=n1;i++){
            dp[i][0] = 0;
        }
        
        for(int i=0;i<=n2;i++){
            dp[0][i] = 0;
        }
        
        for(int ind1=1;ind1<=n1;ind1++){
            for(int ind2=1;ind2<=n2;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1+dp[ind1-1][ind2-1];
                }else{
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }
        
        
        int i=n1;
        int j=n2;
        
        StringBuilder sb = new StringBuilder();
        
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                sb.append(s1.charAt(i-1));
                i--;
            }
            else{
                sb.append(s2.charAt(j-1));
                j--;
            }
        }
        
        while(i>0){
            sb.append(s1.charAt(i-1));
            i--;
        }
        
        while(j>0){
            sb.append(s2.charAt(j-1));
            j--;   
        }
        
        return sb.reverse().toString();
        
    }
    
}