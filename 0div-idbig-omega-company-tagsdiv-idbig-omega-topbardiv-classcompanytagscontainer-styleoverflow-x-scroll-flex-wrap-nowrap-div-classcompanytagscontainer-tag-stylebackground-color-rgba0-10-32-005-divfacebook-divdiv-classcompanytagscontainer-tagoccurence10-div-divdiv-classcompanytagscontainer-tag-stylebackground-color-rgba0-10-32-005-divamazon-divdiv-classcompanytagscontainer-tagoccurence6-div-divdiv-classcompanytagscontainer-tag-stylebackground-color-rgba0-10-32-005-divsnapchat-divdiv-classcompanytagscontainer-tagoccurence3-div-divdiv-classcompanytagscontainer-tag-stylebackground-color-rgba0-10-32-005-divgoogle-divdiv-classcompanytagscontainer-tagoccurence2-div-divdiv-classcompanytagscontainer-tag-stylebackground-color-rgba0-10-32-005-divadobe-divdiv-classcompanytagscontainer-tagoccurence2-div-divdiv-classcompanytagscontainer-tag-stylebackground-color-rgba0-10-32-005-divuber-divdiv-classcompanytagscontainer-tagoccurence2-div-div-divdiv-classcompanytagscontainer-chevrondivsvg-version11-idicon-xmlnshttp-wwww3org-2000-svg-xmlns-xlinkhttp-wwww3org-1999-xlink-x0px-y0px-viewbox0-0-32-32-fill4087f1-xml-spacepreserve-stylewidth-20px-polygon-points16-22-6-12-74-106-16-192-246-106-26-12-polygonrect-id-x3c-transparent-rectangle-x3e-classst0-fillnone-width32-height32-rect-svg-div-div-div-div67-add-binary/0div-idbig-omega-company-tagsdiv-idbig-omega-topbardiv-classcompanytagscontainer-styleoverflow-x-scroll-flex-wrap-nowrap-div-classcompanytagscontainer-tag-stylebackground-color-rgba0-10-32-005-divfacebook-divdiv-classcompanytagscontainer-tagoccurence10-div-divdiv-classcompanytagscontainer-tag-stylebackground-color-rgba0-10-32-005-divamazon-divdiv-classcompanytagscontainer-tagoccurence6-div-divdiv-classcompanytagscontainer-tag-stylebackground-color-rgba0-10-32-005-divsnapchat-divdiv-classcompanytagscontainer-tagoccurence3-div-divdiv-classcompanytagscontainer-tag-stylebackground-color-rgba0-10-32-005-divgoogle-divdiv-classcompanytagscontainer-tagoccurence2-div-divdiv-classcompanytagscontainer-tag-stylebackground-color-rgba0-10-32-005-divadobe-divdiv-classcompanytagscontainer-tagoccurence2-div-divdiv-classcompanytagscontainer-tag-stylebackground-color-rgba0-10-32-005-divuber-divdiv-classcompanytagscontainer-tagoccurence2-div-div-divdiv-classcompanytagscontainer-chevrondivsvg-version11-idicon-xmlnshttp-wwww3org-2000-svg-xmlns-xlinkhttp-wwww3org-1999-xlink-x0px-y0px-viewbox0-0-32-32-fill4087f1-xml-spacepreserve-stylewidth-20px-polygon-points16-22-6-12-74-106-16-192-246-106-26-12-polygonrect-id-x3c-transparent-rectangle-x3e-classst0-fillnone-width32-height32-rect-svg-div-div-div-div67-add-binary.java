class Solution {
    
    public String addBinary(String a, String b) {
    
        int n1 = a.length();
        int n2 = b.length();
        
        int ind1 = n1-1;
        int ind2 = n2-1;
        
        int carry = 0;
        
        StringBuilder ans = new StringBuilder("");
        
        while(ind1>=0 || ind2>=0 || carry>0){
            
            int x = 0;
            if(ind1>=0 && a.charAt(ind1)=='1'){
                x = 1;
            }
            
            int y = 0;
            if(ind2>=0 && b.charAt(ind2)=='1'){
                y = 1;
            }
            
            ans.insert(0,(x+y+carry)%2);
            carry = (x+y+carry)/2;
            ind1--;
            ind2--;
        }
        
        return ans.toString();
    }
    
}