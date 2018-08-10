/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) {
            return false;
        }
        
        boolean[] flag = new boolean[s.length()+1];
        flag[0] = true;
        
        for(int i=0; i<s.length(); i++) {
            if(flag[i] == false) {
                continue;
            }
            
            for(String word: wordDict) {
                int l = word.length();
                int end = i + l;
                if(end > s.length()) {
                    continue;
                }
                
                if(flag[end] == true) {
                    continue;
                }
                
                if(s.substring(i, end).equals(word)) {
                    flag[end] = true;
                }
            }
        }
        
        return flag[s.length()];
    }
}
