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

class WordDictionary {
    
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        return searchHelper(word,0,root);
    }
    
    private boolean searchHelper(String word,int index, Node node){
        
        if(index==word.length()){
            return node.getEnd();
        }
        
        char ch = word.charAt(index);
        
        if(ch=='.'){
            for(Node child : node.links){
                if(child!=null && searchHelper(word,index+1,child)){
                    return true;
                }
            }
            return false;
        }
        else{
            if(node.containsKey(ch)){
                return searchHelper(word,index+1,node.get(ch));
            }
            else{
                return false;
            }
        }
        
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */