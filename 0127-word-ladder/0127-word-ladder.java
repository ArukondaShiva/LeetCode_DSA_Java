class Pair{
    String first;
    int second;
    Pair(String _first,int _second){
        first = _first;
        second = _second;
    }
}

class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    
        Queue<Pair> q = new LinkedList<>();
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        
        while(!q.isEmpty()){
            Pair p = q.peek();
            q.poll();
            
            String word = p.first;
            int steps = p.second;
            
            if(word.equals(endWord)){
                return steps;
            }
            
            for(int i=0;i<word.length();i++){
                
                for(char ch='a';ch<='z';ch++){
                    
                    char charArray[] = word.toCharArray();
                    charArray[i] = ch;
                    
                    String wordString = new String(charArray);
                    
                    if(set.contains(wordString)){
                        set.remove(wordString);
                        q.add(new Pair(wordString,steps+1));
                    }
                    
                }
            }
            
        }
        
        return 0;
    }
    
}