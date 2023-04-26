class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                open.push(i);
            }
            else if(ch=='*'){
                star.push(i);
            }
            else if(ch==')'){
                if(!open.isEmpty()){
                    open.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        
        while(!open.isEmpty()){
            if(star.isEmpty()){
                return false;
            }
            else if(open.peek()<star.peek()){
                open.pop();
                star.pop();
            }else{
                return false;
            }
        }
        
        return true;
    }
}