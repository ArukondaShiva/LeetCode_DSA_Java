class Solution {
    
    
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words,(a,b)->a.length()-b.length());
        
        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        
        int maxi = 1;
        
        for(int cur=1;cur<n;cur++){
            for(int prev=0;prev<cur;prev++){
                if(compare(words[cur],words[prev])&&dp[prev]+1>dp[cur]){
                    dp[cur] = Math.max(dp[cur],dp[prev]+1);
                }
            }
            maxi = Math.max(maxi,dp[cur]);
        }
        
        return maxi;
    }
    
    public boolean compare(String s1,String s2){
        if(s1.length()!=1+s2.length()){
            return false;
        }
        
        int first = 0;
        int second = 0;
        
        while(first<s1.length()){
            if(second<s2.length() && s1.charAt(first)==s2.charAt(second)){
                second++;
            }
            first++;
        }
        return first==s1.length() && second==s2.length();
    }
}