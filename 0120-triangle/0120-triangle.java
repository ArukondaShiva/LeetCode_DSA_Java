class Solution {
    
    
    public int minimumTotal(List<List<Integer>> triangle) {
    
        int n = triangle.size();
        int prev[] = new int[n];
        
        for(int i=n-1;i>=0;i--){
            
            int temp[] = new int[n];
            
            for(int j=0;j<=i;j++){
            
                if(i==n-1){
                    temp[j] = triangle.get(i).get(j);
                    continue;
                }
                
                int down = triangle.get(i).get(j) + prev[j];
                int diagonal = triangle.get(i).get(j) + prev[j+1];
                
                temp[j] = Math.min(down,diagonal);
            }
            
            prev = temp;
        }
        
        return prev[0];
    }
    
}