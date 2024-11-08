class Pair{
    
    int endTime;
    int roomNo;
    
    Pair(int endTime,int roomNo){
        this.endTime = endTime;
        this.roomNo = roomNo;
    }
}

class Solution {
    
    public int mostBooked(int n, int[][] meetings) {
    
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        
        PriorityQueue<Integer> availableHeap = new PriorityQueue<>();
        
        PriorityQueue<Pair> usedHeap = new PriorityQueue<>((a,b)->{
            int compare = a.endTime-b.endTime;
            return compare!=0 ? compare : a.roomNo - b.roomNo;
            });
        
        for(int i=0;i<n;i++){
            availableHeap.add(i);
        }
        
        int counter[] = new int[n];
        Arrays.fill(counter,0);
        
        
        for(int i=0;i<meetings.length;i++){
            
            int start = meetings[i][0];
            int end = meetings[i][1];
            
            while(!usedHeap.isEmpty() && usedHeap.peek().endTime<=start){
                availableHeap.add(usedHeap.poll().roomNo);
            }
            
            if(availableHeap.isEmpty()){
                Pair earliest = usedHeap.poll();
                counter[earliest.roomNo]++;
                usedHeap.add(new Pair(earliest.endTime+(end-start),earliest.roomNo));
            }
            else{
                int roomNo = availableHeap.poll();
                counter[roomNo]++;
                usedHeap.add(new Pair(end,roomNo));   
            }
                
        }
        
        
        int roomNo = 0;
        int maxCount = counter[0];
        
        
        for(int i=1;i<n;i++){
            if(counter[i] > maxCount){
                roomNo = i;
                maxCount = counter[i];
            }   
        }

        return roomNo;
    }
    
}
















