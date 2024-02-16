class Node{
    
    Node links[] = new Node[26];
    boolean isEnd = false;
    
    public void put(char ch,Node node){
        links[ch-'a'] = node;
    }
    
    Node get(char ch){
        return links[ch-'a'];
    }
    
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    
    void setEnd(){
        this.isEnd = true;
    }
    
    boolean getEnd(){
        return isEnd;
    }
    
}

class Solution {
    
    Node root;
    
    Solution(){
        root = new Node();
    }
    
    public void insert(String word){
        
        Node node = root;
        
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node = node.get(ch);
        }
        
        node.setEnd();
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        Solution trie = new Solution();
        
        for(String word : words){
            trie.insert(word);
        }
        
        int n = board.length;
        int m = board[0].length;
        
        int visited[][] = new int[n][m];
        
        for(int r[]: visited){
            Arrays.fill(r,0);
        }
        
        Node node = trie.root;
        
        List<String> result = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                
                 char ch = board[i][j];
                 
                 if(visited[i][j]==0 && node.containsKey(ch)){
                     
                      visited[i][j] = 1;
                      String word = ""+board[i][j];
                      dfs(node.get(ch),i,j,board,visited,word,result);
                      visited[i][j] = 0;
                 }
             }
        }
        
        return result;
    }
    
    
    
    public void dfs(Node node,int i,int j,char[][] board,int[][] visited,String word,List<String> result){
        
        if(node.getEnd()){
            result.add(word);
            node.isEnd = false;
        }
        
        int n = board.length;
        int m = board[0].length;
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,0,-1};
        
        for(int ind=0;ind<4;ind++){
            int nrow = i+delrow[ind];
            int ncol = j+delcol[ind];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && node.containsKey(board[nrow][ncol])){
                visited[nrow][ncol] = 1;
                dfs(node.get(board[nrow][ncol]),nrow,ncol,board,visited,word+board[nrow][ncol],result);
                visited[nrow][ncol] = 0;
            }
            
        }
        
    }
    
    
}










