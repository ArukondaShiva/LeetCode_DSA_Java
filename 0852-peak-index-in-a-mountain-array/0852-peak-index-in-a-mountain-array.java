class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        if(arr.length<3){
            return 0;
        }
        
        int maxLen = 0;
        int maxInd = -1;
        
        int n = arr.length;
        
        for(int i=1;i<n-1;i++){
            if(arr[i-1]<arr[i] && arr[i]>arr[i+1]){
                int left = i-1;
                int right = i+1;
                
                while(left>0 && arr[left]>arr[left-1]){
                    left--;
                }
                
                while(right<n-1 && arr[right]>arr[right+1]){
                    right++;
                }
                
                if(left+right-1 > maxLen){
                    maxLen = left+right-1;
                    maxInd = i;
                }
                
            }
        }
        
        return maxInd;
    }
}