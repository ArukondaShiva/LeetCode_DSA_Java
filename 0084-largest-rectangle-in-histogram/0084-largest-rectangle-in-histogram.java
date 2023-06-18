class Solution {
    
    public int largestRectangleArea(int[] heights) {
    
        int n = heights.length;
        
        int leftSmaller[] = new int[n];
        int rightSmaller[] = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                leftSmaller[i] = st.peek()+1;
            }else{
                leftSmaller[i] = 0;
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            st.pop();
        }
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                rightSmaller[i] = st.peek()-1;
            }else{
                rightSmaller[i] = n-1;
            }
           st.push(i);   
        }
        
        int maxArea = 0;
        int curArea = 0;
        
        for(int i=0;i<n;i++){
            curArea = heights[i]*(rightSmaller[i]-leftSmaller[i]+1);
            maxArea = Math.max(maxArea,curArea);
        }
        
        return maxArea;
    }
    
    
}