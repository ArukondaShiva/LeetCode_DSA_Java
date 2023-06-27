class Solution {
    
    public String reverseWords(String s) {
    
        int n = s.length();
        
        String res = "";
        String temp = "";
        
        int i=0;
        
        while(i<n){
            
            if(s.charAt(i)==' '){
                if(i>0 && s.charAt(i-1)==' '){
                    temp = "";
                }
                else{
                    res = temp+" "+res;
                    temp ="";
                }
            }
            else{
                temp = temp+s.charAt(i);
            }
            
            i++;
        }
        
        res = temp+" "+res;
        
        return res.trim();
    }
    
}