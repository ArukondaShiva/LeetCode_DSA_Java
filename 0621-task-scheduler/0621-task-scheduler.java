class Solution {
    
    public int leastInterval(char[] tasks, int n) {
    
        Map<Character,Integer> map = new HashMap<>();
        
        for(char ch : tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        List<Integer> temp = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.addAll(map.values());
        
        int result = 0;
        
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
            
            result += pq.isEmpty()? temp.size() : n+1;
            temp.clear();
        }
        
        return result;
    }
    
}