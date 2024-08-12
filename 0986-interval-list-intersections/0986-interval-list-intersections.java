class Solution {
    
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> resList = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while(i<firstList.length && j<secondList.length){
            
            int latestStart = Math.max(firstList[i][0] , secondList[j][0]);
            int earliestEnd = Math.min(firstList[i][1] , secondList[j][1]);
            
            if(latestStart <= earliestEnd){
                resList.add(new int[]{latestStart,earliestEnd});
            }
            
            if(earliestEnd == firstList[i][1]){
                i++;
            }else{
                j++;
            }
        }
        
        int[][] resArr =  new int[resList.size()][2];
        int k = 0;
        
        for(int r[] : resList){
            resArr[k][0] = r[0];
            resArr[k][1] = r[1];
            k++;
        }
        
        return resArr;
    }
    
}