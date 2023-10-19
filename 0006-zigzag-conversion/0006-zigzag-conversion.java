class Solution {

    public String convert(String s, int numRows) {
        int n = s.length();
        
        if(numRows==1){
            return s;
        }
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0;i<numRows;i++){
            list.add("");
        }
        
        int flag = 0;
        
        int i = 0;
        int row = 0;
        while(i<n){
            
            if(flag==0){
                while(row<numRows && i<n){
                  list.set(row,list.get(row)+Character.toString(s.charAt(i)));
                  i++;
                  row++;   
                }
                flag = 1;
                row = row-2;
            }
            else{
                while(row>=0 && i<n){
                    list.set(row,list.get(row)+Character.toString(s.charAt(i)));
                    i++;
                    row--;
                }
                flag = 0;
                row = 1;
            }
            
        }
        
        String res = "";
        for(String str : list){
            res = res+str;
        }
        
        return res;
    }
}
