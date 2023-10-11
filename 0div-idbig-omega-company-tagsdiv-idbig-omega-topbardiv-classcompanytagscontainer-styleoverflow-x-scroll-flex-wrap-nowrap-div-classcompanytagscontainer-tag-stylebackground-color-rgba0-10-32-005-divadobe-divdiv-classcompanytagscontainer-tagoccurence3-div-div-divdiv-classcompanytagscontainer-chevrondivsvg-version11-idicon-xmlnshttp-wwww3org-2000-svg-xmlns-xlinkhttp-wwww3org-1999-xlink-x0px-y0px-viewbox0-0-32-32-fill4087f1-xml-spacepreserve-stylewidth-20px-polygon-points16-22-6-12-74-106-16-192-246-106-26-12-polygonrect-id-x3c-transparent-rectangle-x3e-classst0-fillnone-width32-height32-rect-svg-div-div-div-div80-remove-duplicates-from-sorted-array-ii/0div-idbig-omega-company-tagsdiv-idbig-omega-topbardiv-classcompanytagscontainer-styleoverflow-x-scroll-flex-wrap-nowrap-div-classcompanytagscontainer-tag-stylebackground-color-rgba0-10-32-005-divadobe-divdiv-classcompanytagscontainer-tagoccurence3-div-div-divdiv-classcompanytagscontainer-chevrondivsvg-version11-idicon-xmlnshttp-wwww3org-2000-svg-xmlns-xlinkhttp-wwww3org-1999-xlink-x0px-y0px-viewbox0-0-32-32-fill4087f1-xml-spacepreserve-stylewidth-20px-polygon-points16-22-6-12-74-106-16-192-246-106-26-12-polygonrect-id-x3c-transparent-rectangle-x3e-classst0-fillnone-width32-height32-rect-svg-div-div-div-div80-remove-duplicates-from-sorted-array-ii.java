class Solution {
    
    public int removeDuplicates(int[] arr) {
    
        int n = arr.length;
        
        int j = 2;
        int i = 2;
        
        while(j<n){
            if(arr[j]==arr[i-2]){
                j++;
            }
            else{
                arr[i] = arr[j];
                i++;
                j++;
            }
        }
        
        return i;
        
    }
    
}