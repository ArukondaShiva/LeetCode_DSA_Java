class Solution {
    
    public int maxDepth(String s) {
    
        Stack<Character> st = new Stack<>();
        int maxLen = 0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                int size = st.size();
                maxLen = Math.max(size,maxLen);
                st.pop();
            }
        }
        return maxLen;
    }
    
}