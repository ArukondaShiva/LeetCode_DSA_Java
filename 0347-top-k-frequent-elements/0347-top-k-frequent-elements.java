class Pair{
    int num;
    int count;
    Pair(int _num,int _count){
        num = _num;
        count = _count;
    }
}

class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
    
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.count-a.count);
        
        for(Map.Entry<Integer,Integer> it : map.entrySet()){
            pq.add(new Pair(it.getKey(),it.getValue()));
        }
        
        int result[] = new int[k];
        int ind = 0;
        
        while(k>0 && !pq.isEmpty()){
            Pair p = pq.poll();
            result[ind++] = p.num;
            k--;
        }
        
        return result;
    }
    
}