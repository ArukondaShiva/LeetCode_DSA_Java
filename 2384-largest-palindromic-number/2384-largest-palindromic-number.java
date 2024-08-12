class Solution {
    
    public String largestPalindromic(String num) {
        
        System.out.println(num.length());
        
        Map<Character,Integer> map = new HashMap<>();
        int n = num.length();
        
        for(int i=0;i<n;i++){
            char ch = num.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        ArrayList<String> leftHalf = new ArrayList<>();
        String middle = "";
        
        for(char digit='9';digit>='0';digit--){
            
            if(map.containsKey(digit)){
                
                int occurances = map.get(digit);
                int pairs = occurances/2;
                
                if(pairs>0){
                    
                    if(leftHalf.isEmpty() && digit=='0'){
                        map.put(digit,1);
                    }
                    else{
                        StringBuilder sb = new StringBuilder("");
                
                        for(int i=0;i<pairs;i++){
                           sb.append(digit);
                        }
                        leftHalf.add(sb.toString());   
                    }
                }
                
                if(middle.length()==0 && occurances%2==1){
                    middle = ""+digit;
                }
                
            }
            
        }
        
        if(middle.isEmpty() && leftHalf.isEmpty()){
            return "0";
        }
        
        StringBuilder sbres = new StringBuilder();
        
        for(String str : leftHalf){
             sbres.append(str);
        }
        
        sbres.append(middle);
        Collections.reverse(leftHalf);
        
        for(String str : leftHalf){
             sbres.append(str);
        }
        
        return sbres.toString();
    }
    
}