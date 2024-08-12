class Solution {
    
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
    
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int i = 0;
        int numOfStops = 0;
        int n = stations.length;
        
        while(startFuel<target){
            
            while(i<n && stations[i][0]<=startFuel){
                pq.add(stations[i][1]);
                i++;
            }
            
            if(pq.isEmpty()){
                return -1;
            }
            
            startFuel += pq.poll();
            numOfStops++;
        }
        
        return numOfStops;
    }
    
}