class Pair{
    int cap;
    int pro;
    Pair(int cap,int pro){
        this.cap = cap;
        this.pro = pro;
    }
}

class Solution {
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int n = capital.length;
        
        List<Pair> projects = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            projects.add(new Pair(capital[i],profits[i]));
        }
        
        Collections.sort(projects,(a,b)->a.cap-b.cap);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        int i = 0;
        
        while(k-->0){
        
            while(i<n && projects.get(i).cap<=w){
                pq.add(projects.get(i).pro);
                i++;
            }
            
            if(!pq.isEmpty()){
               w += pq.poll();
            }
        }
        
        return w;
    }
    
}





