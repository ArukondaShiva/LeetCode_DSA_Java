class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        int n = nums.length;
        return LDS(nums,n);
        
    }
    
    
    public List<Integer> LDS(int arr[],int n){
        
         Arrays.sort(arr);
        
        
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        
        int hash[] = new int[n];
        
        int len = 1;
        int lastIndex = 0;
        
        for(int i=0;i<n;i++){
            hash[i] = i;
            for(int prev=0;prev<i;prev++){
                
                if((arr[i]%arr[prev]==0 || arr[prev]%arr[i]==0) && dp[prev]+1 > dp[i]){
                    
                    dp[i] = dp[prev]+1;
                    hash[i] = prev;
                    
                }
            }
            
            if(dp[i]>len){
                len = dp[i];
                lastIndex  = i;
            }
            
        }
        
        
        
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[lastIndex]);
        
        while(hash[lastIndex]!=lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(arr[lastIndex]);
        }
        
        Collections.reverse(ans);
        return ans;
        
    }
    
    
    
}