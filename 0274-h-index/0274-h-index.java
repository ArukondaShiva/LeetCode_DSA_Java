class Solution {
    
    public int hIndex(int[] citations) {
    
        int n = citations.length;
        int low = 0;
        int high = n;
        
        int hInd = -1;
        while(low<=high){
            int h = (low+high)/2;
            
            if(isPossible(citations,h)){
                hInd = h;
                low = h+1;
            }
            else{
                high = h-1;
            }
        }
        
        return hInd;
    }
    
    public boolean isPossible(int citations[],int h){
        
        int count = 0;
        int n = citations.length;
        for(int i=0;i<n;i++){
            if(citations[i]>=h){
                count++;
            }
        }
        
        return count>=h;
    }
    
}