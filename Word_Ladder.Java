/*
https://leetcode.com/problems/word-ladder/description/
*/
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        wordList.add(endWord);
        
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        
        HashMap<String, Integer> length = new HashMap<String, Integer>();
        length.put(beginWord, 1);
        
        while(q.peek() != null) {
            String currWord = q.poll();
            if(currWord.equals(endWord)) {
                return length.get(currWord);
            }
            
            //String prevWord = currWord.toString();
            StringBuilder word = new StringBuilder(currWord);
            
            for(int i=0; i<currWord.length(); i++) {
                char orig = word.charAt(i);
                for(char c = 'a'; c <= 'z'; c++) {
                    
                    if(c != word.charAt(i)) {
                        word.setCharAt(i, c);
                        String temp = word.toString();
                        if(length.get(temp) == null && wordList.contains(temp)) {
                            q.add(temp);
                            length.put(temp, length.get(currWord) + 1);
                        }
                    }
                }
                word.setCharAt(i, orig);
            }
        }
        
        return 0;
    }
}
