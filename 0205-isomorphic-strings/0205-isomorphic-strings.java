class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length()!=t.length()){
            return false;
        }
        
        HashMap<Character,Character> smap = new HashMap<>();
        HashMap<Character,Character> tmap = new HashMap<>();
        
        int n = s.length();
        
        for(int i=0;i<n;i++){
            
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if((smap.containsKey(ch1)&&smap.get(ch1)!=ch2) || (tmap.containsKey(ch2)&&tmap.get(ch2)!=ch1)){
                return false;
            }
            
            smap.put(ch1,ch2);
            tmap.put(ch2,ch1);
        }
        return true;
    }
}