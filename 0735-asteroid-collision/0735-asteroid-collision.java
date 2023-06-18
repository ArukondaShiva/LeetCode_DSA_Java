class Solution {
    
    public int[] asteroidCollision(int[] asteroids) {
    
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        
        for(int i=0;i<n;i++){
            int element = asteroids[i];
        
            while(!st.isEmpty() && st.peek()>0 && element<0){
              int diff = element+st.peek();
              if(diff==0){
                  st.pop();
                  element = 0;
              }      
              else if(diff<0){
                  st.pop();
              }
              else if(diff>0){
                  element = 0;
              } 
            }
            
            if(element!=0){
                st.push(element);
            }
            
        }
        
        int size = st.size();
        int result[] = new int[size];
        int ind =size-1;
        
        while(!st.isEmpty()){
            result[ind--] = st.pop();
        }
        
        return result;
    }
    
}