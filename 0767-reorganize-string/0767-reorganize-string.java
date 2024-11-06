class Pair{
    
    char ch;
    int freq;
    
    Pair(char ch,int freq){
        this.ch = ch;
        this.freq = freq;
    }
    
}

class Solution {
    
    public String reorganizeString(String s) {
        
        int n = s.length();
    
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);
        
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            if(map.get(ch)>((n+1)/2)){
                return "";
            }
        }
                
        for(Map.Entry<Character,Integer> it : map.entrySet()){
            pq.add(new Pair(it.getKey(),it.getValue()));
        }
        
        StringBuilder sb = new StringBuilder("");

        while(pq.size()>=2){
            
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();
            
            sb.append(p1.ch);
            sb.append(p2.ch);
            
            if(p1.freq>1){
                pq.add(new Pair(p1.ch,p1.freq-1));
            }
            
            if(p2.freq>1){
                pq.add(new Pair(p2.ch,p2.freq-1));
            }
            
        }
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            sb.append(p.ch);
        }
        
        return sb.toString();
    }
    
}












