class Solution {
  
    public int minDays(int[] bloomDay, int m, int k) {
     
        
        int low = 1;
        int high = (int)(1e9);
        int ans = -1;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(canMakeBouquets(bloomDay,mid,m,k)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return ans;
    }
    
    public boolean canMakeBouquets(int bloomDay[],int dayNum,int m,int k){
        
        int makeBouquets = 0;
        
        int intCount = 0;
        
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=dayNum){
                intCount++;
                if(intCount==k){
                    makeBouquets++;
                    intCount = 0;
                }
            }
            else{
                intCount = 0;
            }
        }
        
        return makeBouquets>=m;
    }
    
}