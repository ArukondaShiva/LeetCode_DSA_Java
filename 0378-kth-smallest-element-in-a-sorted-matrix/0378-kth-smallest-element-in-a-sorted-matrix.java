class Pair{
    int val;
    int valInd;
    int arrInd;
    Pair(int val,int valInd,int arrInd){
        this.val = val;
        this.valInd = valInd;
        this.arrInd = arrInd;
    }
}

class Solution {
    
    public int kthSmallest(int[][] matrix, int k) {
    
        int n = matrix.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        
        for(int i=0;i<n;i++){
            if(matrix[0].length>0){
                pq.add(new Pair(matrix[i][0],0,i));
            }
        }
        
        while(k-->1 && !pq.isEmpty()){
            
            Pair p = pq.poll();
            int val = p.val;
            int valInd = p.valInd;
            int arrInd = p.arrInd;
            
            if(valInd+1 < matrix[arrInd].length){
                pq.add(new Pair(matrix[arrInd][valInd+1],valInd+1,arrInd));
            }
            
        }
        
        return !pq.isEmpty() ? pq.peek().val : -1;
    }
    
}












