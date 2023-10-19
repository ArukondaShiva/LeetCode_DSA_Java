class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int ind1 = 0;
        int ind2 = 0;
        int n1 = s.length();
        int n2 = t.length();
        return checkSubsequence(0,0,s,t,n1,n2);
        
    }
    
    public boolean checkSubsequence(int ind1,int ind2,String s,String t,int n1,int n2){
        
        if(ind1==n1){
            return true;
        }
        
        if(ind2==n2){
            return false;
        }
        
        
        if(s.charAt(ind1)==t.charAt(ind2)){
          return  checkSubsequence(ind1+1,ind2+1,s,t,n1,n2);
        }
        else{
          return checkSubsequence(ind1,ind2+1,s,t,n1,n2);
        }
    
    }
    
}