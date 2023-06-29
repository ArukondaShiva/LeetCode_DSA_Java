class Solution {
    
    public String frequencySort(String s) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.val-a.val);
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        
        for(Map.Entry<Character,Integer> it : map.entrySet()){
            Pair pair = new Pair(it.getValue(),it.getKey());
            pq.add(pair);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size()!=0){
            
            Pair it = pq.poll();
            char ch = it.c;
            int count = it.val;
            
            while(count>0){
                sb.append(ch);
                count--;
            }
            
        }
        return sb.toString();
    }
    
    
}


class Pair{
    int val;
    char c;
    Pair(int _val,char _c){
        val = _val;
        c = _c;
    }
}