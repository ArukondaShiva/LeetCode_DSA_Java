class Solution {
    
    public int reversePairs(int[] nums) {
       return mergeSort(nums,0,nums.length-1);
    }
    
    public int mergeSort(int nums[],int low,int high){
        
        int count=0;
        
        if(low>high){
            return count;
        }
        
        if(low<high){
            int mid = (high+low)/2;
            count+=mergeSort(nums,low,mid);
            count+=mergeSort(nums,mid+1,high);
            count+=countPairs(nums,low,mid,high);
            mergeArrays(nums,low,mid,high);
        }
        
        return count;
    }
    
    public void mergeArrays(int nums[],int low,int mid,int high){
        
        int n1 = mid-low+1;
        int n2 = high-mid;
        
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];
        
        for(int i=0;i<n1;i++){
            leftArray[i] = nums[low+i];
        }
        
        for(int j=0;j<n2;j++){
            rightArray[j] = nums[mid+1+j];
        }
        
        
        int i=0;
        int j=0;
        
        int k = low;
        
        while(i<n1 && j<n2){
            
            if(leftArray[i]<=rightArray[j]){
                nums[k] = leftArray[i];
                i++;
                k++;
            }
            else{
                nums[k] = rightArray[j];
                j++;
                k++;
            }
            
        }
        
        while(i<n1){
            nums[k] = leftArray[i];
            k++;
            i++;
        }
        
        while(j<n2){
            nums[k] = rightArray[j];
            k++;
            j++;
        }
        
    }
    
    
    public int countPairs(int arr[],int low,int mid,int high){
        
        int right = mid+1;
        int cnt = 0;
        
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long)arr[i] > (2 * (long)arr[right])){
                right++;
            } 
            cnt += (right - (mid + 1));
        }
        return cnt;
        
    }
    
}








