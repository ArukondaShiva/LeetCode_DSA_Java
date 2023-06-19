class Solution {
    
    public int maximalRectangle(char[][] matrix) {
    
        int n = matrix.length;
        int m = matrix[0].length;
        
        int dp[][] = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    int upsteps = 0;
                    if(i>0){
                        upsteps = dp[i-1][j];
                    }
                    dp[i][j] = 1+upsteps;
                }
            }
        }
        
        int maxArea = 0;
        
        for(int i=0;i<n;i++){
            int curArea = largestAreaHistogram(dp[i]);
            maxArea = Math.max(curArea,maxArea);
        }
        
        return maxArea;
    }
    
    
    public int largestAreaHistogram(int arr[]){
        
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        
        int res = 0;
        int cur = 0;
        
        for(int i=0;i<n;i++){
            
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                int tp = st.peek();
                st.pop();
                cur = arr[tp]*(st.isEmpty()==true ? i : i-st.peek()-1 );
                res = Math.max(res,cur);
            }
            
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int tp = st.peek();
            st.pop();
            cur = arr[tp]*(st.isEmpty()==true ? n : n-st.peek()-1);
            res = Math.max(res,cur);
        }
        
        return res;
    }
    
    
}




