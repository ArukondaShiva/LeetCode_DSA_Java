class Solution {
    
    public boolean isNStraightHand(int[] hand, int groupSize) {
    
        if(hand.length%groupSize !=0){
            return false;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : hand){
            pq.add(num);
        }
        
        while(!pq.isEmpty()){
            
            int first = pq.poll();
            
            for(int i=1;i<groupSize;i++){
                if(!pq.contains(first+i)){
                    return false;
                }
                pq.remove(first+i);
            }
            
        }
        
        return true;
    }
    
}