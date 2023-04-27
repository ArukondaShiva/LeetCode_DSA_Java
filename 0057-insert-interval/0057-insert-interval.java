class Solution {
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
    
        List<int[]> result = new ArrayList<>();
        
        for(int it[] : intervals){
            
            if(it[1]<newInterval[0]){
                result.add(it);
            }
            else if(newInterval[1]<it[0]){
                result.add(newInterval);
                newInterval = it;
            }else{
                newInterval[0] = Math.min(newInterval[0],it[0]);
                newInterval[1] = Math.max(newInterval[1],it[1]);
            }
            
        }
        
        result.add(newInterval);
        
        return result.toArray(new int[result.size()][2]);
    }
    
}