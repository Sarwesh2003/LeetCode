class WordDictionary {
    private WordDictionary[] childs;
    boolean isTerminal;
    public WordDictionary() {
        childs = new WordDictionary[26];
        isTerminal = false;
    }
    
    public void addWord(String word) {
        WordDictionary curr = this;
        for(char c : word.toCharArray()){
            if(curr.childs[c - 'a'] == null)
                curr.childs[c - 'a'] = new WordDictionary();
            curr = curr.childs[c - 'a'];
        }
        curr.isTerminal = true;
    }
    
    public boolean search(String word) {
        WordDictionary curr = this;
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(WordDictionary c : curr.childs){
                    if(c != null && c.search(word.substring(i + 1))){
                        return true;
                    }
                }
                return false;
            }else{
                if(curr.childs[ch - 'a'] == null) return false;
                curr = curr.childs[ch - 'a'];
            }
        }
        return curr != null && curr.isTerminal;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */