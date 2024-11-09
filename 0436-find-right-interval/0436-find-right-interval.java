class Pair{
    int time;
    int ind;
    Pair(int time,int ind){
        this.time = time;
        this.ind = ind;
    }
}

class Solution {
    
    public int[] findRightInterval(int[][] intervals) {
        
        int n = intervals.length;
    
        PriorityQueue<Pair> startTimeHeap = new PriorityQueue<>((a,b)->a.time-b.time);
        PriorityQueue<Pair> endTimeHeap = new PriorityQueue<>((a,b)->a.time-b.time);
        
        for(int i=0;i<intervals.length;i++){
            startTimeHeap.add(new Pair(intervals[i][0],i));
            endTimeHeap.add(new Pair(intervals[i][1],i));
        }
        
        int result[] = new int[n];
        Arrays.fill(result,-1);
        int ind = 0;
        
        while(!endTimeHeap.isEmpty()){
            
            Pair endPair = endTimeHeap.poll();
            int endTime = endPair.time;
            
            while(!startTimeHeap.isEmpty() && startTimeHeap.peek().time<endTime){
                startTimeHeap.poll();
            }
            
            if(!startTimeHeap.isEmpty()){
                result[endPair.ind] = startTimeHeap.peek().ind;
            }
        }
        
        return result;
    }
    
}