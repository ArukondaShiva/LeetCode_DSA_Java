class Pair{
    int num;
    int ind;
    Pair(int num,int ind){
        this.num = num;
        this.ind = ind;
    }
}

class Solution {
    
    public int[] maxSubsequence(int[] nums, int k) {
    
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.num-b.num);
        
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
            if(pq.size()>k){
                pq.poll();
            }
        }
            
        List<Pair> result = new ArrayList<>(pq);
        Collections.sort(result,(a,b)->a.ind-b.ind);
        
        int[] resultArr = new int[k];
        for(int i=0;i<k;i++){
            resultArr[i] = result.get(i).num;
        }
            
        return resultArr;
    }
    
}