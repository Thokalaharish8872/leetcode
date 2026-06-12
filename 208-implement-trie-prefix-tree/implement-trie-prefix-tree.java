class TrieNode{

        TrieNode[] links = new TrieNode[26];
        boolean flag;

        TrieNode(){};

        boolean containsChar(char ch){
            return links[ch - 'a'] != null;
        }

        void setChar(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }

        TrieNode getChar(char ch){
            return links[ch - 'a'];
        }

        void setEnd(){
            flag = true;
        }

        boolean isEnd(){
            return flag;
        }
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;

        for(char w : word.toCharArray()){
            if(!node.containsChar(w))
                node.setChar(w, new TrieNode());

            node = node.getChar(w);
        }

        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = root;

        for(char w : word.toCharArray()){
            if(!node.containsChar(w))
                return false;
            
            node = node.getChar(w);
        }

        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for(char w : prefix.toCharArray()){
            if(!node.containsChar(w))
                return false;
            
            node = node.getChar(w);
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */