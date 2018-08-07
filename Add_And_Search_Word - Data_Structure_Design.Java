/*
https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
*/
class TrieNode {
    char val;
    boolean isEnd;
    TrieNode[] children;
    
    public TrieNode() {
        val = '$';
        isEnd = false;
        children = new TrieNode[26]; 
    }
}

public class WordDictionary {

    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null) {
            return;
        }
        
        char[] w = word.toCharArray();
        TrieNode curr = root;
        
        for(int i=0; i<w.length; i++) {
            int c = w[i]-'a';
            if(curr.children[c] == null) {
                TrieNode temp = new TrieNode();
                temp.val = (char)c;
                curr.children[c] = temp;
                curr = temp;
            } else {
                curr = curr.children[c];
            }
        }
        
        if(curr != root) {
            curr.isEnd = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null) {
            return false;
        }
        
        char[] w = word.toCharArray();
        TrieNode curr = root;
        
        return search(root, w, 0);
    }
    
    boolean search(TrieNode curr, char[] word, int pos) {
        if(pos == word.length) {
            if(curr.isEnd) {
                return true;
            } else {
                return false;
            }
        }
        
        boolean ret = false;
        if(word[pos] == '.') {
            for(TrieNode child: curr.children) {
                if(child != null) {
                    ret = search(child, word, pos+1);
                    if(ret) {
                        return ret;
                    }
                }
            }
        } else {
            TrieNode temp = curr.children[word[pos]-'a'];
            if(temp != null) {
                ret = search(temp, word, pos+1);
            }
        }
        
        return ret;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
