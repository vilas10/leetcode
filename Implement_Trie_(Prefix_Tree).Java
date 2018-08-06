/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/
class TrieNode {
    // Initialize your data structure here.
    char val;
    boolean isEnd;
    TrieNode[] children;
    
    public TrieNode() {
        val = '$';
        isEnd = false;
        children = new TrieNode[26];
    }
    
    public TrieNode subNode(char c) {
        if(children != null) {
            return children[c - 'a'];
        }
        
        return null;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++) {
            char newval = word.charAt(i);
            TrieNode exist = curr.subNode(newval);
        
            if(exist == null) {
                TrieNode temp = new TrieNode();
                temp.val = newval;
                curr.children[newval - 'a'] = temp;
                curr = temp;
            } else {
                curr = exist;
            }
        }
        
        curr.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++) {
            
            curr = curr.subNode(word.charAt(i));
            
            if(curr == null || curr.val != word.charAt(i)) {
                return false;
            }
        }
        
        return curr.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for(int i=0; i<prefix.length(); i++) {
            curr = curr.subNode(prefix.charAt(i));
            
            if(curr == null || curr.val != prefix.charAt(i)) {
                return false;
            }
            
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
