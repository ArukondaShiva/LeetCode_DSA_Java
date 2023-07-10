class Solution {
    
    public String reverseVowels(String s) {
    
        int n = s.length();
        
        int i = 0;
        int j = n-1;
        
        char[] charArray = s.toCharArray();
        
        while(i<j){
            if(isVowel(charArray[i]) && isVowel(charArray[j])){
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
            }
            else if(isVowel(charArray[i])){
                j--;
            }
            else if(isVowel(charArray[j])){
                i++;
            }
            else{
                i++;
                j--;
            }
        }
        
        return String.valueOf(charArray);
    }
    
    public boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U';
    }
    
}