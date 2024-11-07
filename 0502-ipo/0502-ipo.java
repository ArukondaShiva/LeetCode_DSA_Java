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
        PriorityQueue<Pair> minCapitalHeap = new PriorityQueue<>((a,b)->a.cap-b.cap);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a,b)->b-a);
        
        for(int i=0;i<n;i++){
            minCapitalHeap.add(new Pair(capital[i],profits[i]));
        }
        
        while(k-->0){
            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek().cap<=w){
                maxProfitHeap.add(minCapitalHeap.poll().pro);
            }
            if(!maxProfitHeap.isEmpty()){
                w += maxProfitHeap.poll();
            }
        }
        
        return w;
    }
    
}





