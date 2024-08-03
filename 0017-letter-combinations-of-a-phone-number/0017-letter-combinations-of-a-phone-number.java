class Solution {
    
    public List<String> letterCombinations(String digits) {
    
        String options[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        
        if(digits.equals("")){
            return result;
        }
        
        findCombinations("",Integer.parseInt(digits),options,result);
        return result;
    }
    
    public void findCombinations(String res,int digits,String[] options,List<String> result){
        
        if(digits==0){
            result.add(res);
            return;
        }
        
        int digit = digits%10;
        String numStr = options[digit];
        
        for(int i=0;i<numStr.length();i++){
            String ch = ""+String.valueOf(numStr.charAt(i));
            findCombinations(ch+res,digits/10,options,result);
        }
        
    }
    
    
}