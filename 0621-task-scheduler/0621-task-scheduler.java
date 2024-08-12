class Solution {
    
    public int leastInterval(char[] tasks, int n) {
    
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.addAll(map.values());
        
        List<Integer> temp = new ArrayList<>();
        int totalTime = 0;
        
        while(!pq.isEmpty()){
            
            for(int i=0;i<=n;i++){
                if(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
            
            for(int i=0;i<temp.size();i++){
                int val = temp.get(i);
                val--;
                if(val>0){
                    pq.add(val);
                }
            }
            
            totalTime += pq.isEmpty() ? temp.size() : n+1; 
            temp.clear();
        }
        
        return totalTime;
    }
    
}