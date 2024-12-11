class Solution {
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        if(n==1){
            return nums[0];
        }
        
        int arr1[] = new int[n-1];
        int arr2[] = new int[n-1];
        
        int k1 = 0;
        int k2 = 0;
        
        for(int i=0;i<n;i++){
            
            if(i==0){
                arr1[k1++] = nums[i];
            }
            else if(i==n-1){
                arr2[k2++] = nums[i];
            }else{
                arr1[k1++] = nums[i];
                arr2[k2++] = nums[i];
            }
        }
        
        int firstArrMax = findMaxSumArr(arr1);
        int secondArrMax = findMaxSumArr(arr2);
        
        return Math.max(firstArrMax,secondArrMax);
    }
    
    
    public int findMaxSumArr(int nums[]){
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return findMaxSumArrMen(n-1,nums,dp);
    }
    
    public int findMaxSumArrMen(int ind,int nums[],int dp[]){
        
        if(ind==0){
            return nums[ind];
        }
        
        if(ind<0){
            return 0;
        }
        
        if(dp[ind]!=-1){
            return dp[ind];
        }
        
        int pick = nums[ind]+findMaxSumArrMen(ind-2,nums,dp);
        int notPick = 0+findMaxSumArrMen(ind-1,nums,dp);
        
        return dp[ind] = Math.max(pick,notPick);
    }
    
}