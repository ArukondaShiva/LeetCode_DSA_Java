class Solution {
    
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    
        List<int[]> resList = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while(i<firstList.length && j<secondList.length){
            
            int firstStart = firstList[i][0];
            int firstEnd = firstList[i][1];
            
            int secondStart = secondList[j][0];
            int secondEnd = secondList[j][1];
            
            int latestST = Math.max(firstStart,secondStart);
            int earliestET = Math.min(firstEnd,secondEnd);
            
            if(latestST<=earliestET){
                resList.add(new int[]{latestST,earliestET});
            }
             
            if(earliestET==firstEnd){
                i++;
            }else{
                j++;
            }
                
        }
        
        int[][] resArr = new int[resList.size()][2];
        int k = 0;
        for(int r[] : resList){
            resArr[k][0] = r[0];
            resArr[k][1] = r[1];
            k++;
        }
        
        return resArr;
    }
    
}