class Solution {
    
    public int twoCitySchedCost(int[][] costs) {
    
        Arrays.sort(costs, (a,b)->(a[0]-a[1])-(b[0]-b[1]));
        
        int sum = 0;
        int n = costs.length;
        
        int i = 0;
        
        for(;i<n/2;i++){
            sum = sum + costs[i][0];
        }
        
        for(;i<n;i++){
            sum = sum + costs[i][1];
        }
        
        return sum;
    }
    
}