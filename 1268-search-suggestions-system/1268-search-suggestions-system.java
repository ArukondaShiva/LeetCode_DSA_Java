class Node{
    
    Node links[] = new Node[26];
    boolean isEnd = false;
    
    Node(){
    }
    
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    
    void put(char ch,Node node){
        links[ch-'a'] = node;
    }
    
    Node get(char ch){
        return links[ch-'a'];
    }
    
    void setEnd(){
        isEnd = true;
    }
    
    boolean getEnd(){
        return isEnd;
    }
    
}

class Solution {
    
    private Node root;
    
    Solution(){
        root = new Node();
    }
    
    public void insert(String word){
        
        Node node = root;
        
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    
    public List<String> findProducts(String prefix){
        
        Node node = root;
        
        List<String> subList = new ArrayList<>();
        StringBuilder word = new StringBuilder(prefix);
                
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(node.containsKey(ch)){
                node = node.get(ch);
            }
            else{
                return subList;
            }
        }
                
        dfs(node,word,subList);
        return subList;
    }
    
    
    public void dfs(Node node,StringBuilder word,List<String> subList){
        
        if(node.getEnd()==true && subList.size()<3){
            subList.add(word.toString());
        }
        else if(subList.size()==3 || node.getEnd()){
            return;
        }
        
        for(int i=0;i<26;i++){
            if(node.links[i]!=null){
                char ch = (char)('a'+i);
                word.append(ch);
                dfs(node.links[i],word,subList);
                word.deleteCharAt(word.length()-1);
            }
        }
        
    }
 
    
   
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    
        for(int i=0;i<products.length;i++){
            insert(products[i]);
        }
        
        List<List<String>> list = new ArrayList<>();
        
        String prefix ="";
        
        for(int i=0;i<searchWord.length();i++){
            prefix = prefix+searchWord.charAt(i);
            list.add(findProducts(prefix));
        }
        
        return list;
    }
    
}




























