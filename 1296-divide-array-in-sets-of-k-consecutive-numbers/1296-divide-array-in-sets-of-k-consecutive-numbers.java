class Solution {
    
    public boolean isPossibleDivide(int[] nums, int k) {
    
        if(nums.length%k != 0){
            return false;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : nums){
            pq.add(num);
        }
        
        while(!pq.isEmpty()){
            int first = pq.poll();
            for(int i=1;i<k;i++){
                if(!pq.contains(first+i)){
                    return false;
                }
                pq.remove(first+i);
            }
        }
        
        return true;
    }
    
}