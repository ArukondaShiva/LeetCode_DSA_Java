class Solution {
    
    public int shipWithinDays(int[] weights, int days) {
    
        int totalWeights = 0;
        
        for(int i=0;i<weights.length;i++){
            totalWeights = totalWeights + weights[i];
        }
        
        int low = 0;
        
        for(int i=0;i<weights.length;i++){
            low = Math.max(low,weights[i]);
        }
        
        int high = totalWeights;
        int ans = -1;
        
        while(low<=high){
            
            int mid = low+(high-low)/2;
            
            if(isShipPossible(weights,mid,days)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
            
        }
        
        return ans;
    }
    
    
    public boolean isShipPossible(int weights[],int W,int days){
        
        int count = 1;
        int sum = 0;
        
        for(int num : weights){
            sum += num;
            
            if(sum>W){
                sum = num;
                count++;
            }
        }
        
        return count<=days;
    }
    
}






