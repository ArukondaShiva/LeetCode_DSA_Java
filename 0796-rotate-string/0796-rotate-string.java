class Solution {
    
    public boolean rotateString(String s, String goal) {
        
        if(s.length()!=goal.length()){
            return false;
        }
        
        if(s.equals(goal)){
            return true;
        }
        
        int n = s.length();
        
        for(int i=0;i<n;i++){
            s = s.substring(1)+s.substring(0,1);
            if(s.equals(goal)){
                return true;
            }
        }
        
        return false;
    }
    
}