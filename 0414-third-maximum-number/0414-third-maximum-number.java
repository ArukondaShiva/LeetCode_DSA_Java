class Solution {
    
    public int thirdMax(int[] nums) {
   
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            if(set.add(num)){
                 
                pq.add(num);
                if(pq.size()>3){
                    pq.poll();
                }
                
            }
        }
       
        if(pq.size()<3){
            while(pq.size()>1){
                pq.poll();
            }
        }
        
        return pq.peek();
    }
    
}