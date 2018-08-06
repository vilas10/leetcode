/*
Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  Here, we have groups, of adjacent letters that are all the same character, and adjacent characters to the group are different.  A group is extended if that group is length 3 or more, so "e" and "o" would be extended in the first example, and "i" would be extended in the second example.  As another example, the groups of "abbcccaaaa" would be "a", "bb", "ccc", and "aaaa"; and "ccc" and "aaaa" are the extended groups of that string.

For some given string S, a query word is stretchy if it can be made to be equal to S by extending some groups.  Formally, we are allowed to repeatedly choose a group (as defined above) of characters c, and add some number of the same character c to it so that the length of the group is 3 or more.  Note that we cannot extend a group of size one like "h" to a group of size two like "hh" - all extensions must leave the group extended - ie., at least 3 characters long.

Given a list of query words, return the number of words that are stretchy. 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not extended.
Notes:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters
*/
class Solution {
    class CharCount {
        public char c;
        public int count;
        
        public CharCount(char ch, int cnt) {
            c = ch;
            count = cnt;
        }
    }
    
    public int expressiveWords(String S, String[] words) {
        if (S == null) return 0;
        if (S.length() == 0) {
            int len = 0;
            for (String s: words) {
                if (s.isEmpty()) len++;
            }
            
            return len;
        }
        
        List<CharCount> list = init(S);
        int result = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null && words[i].length() > 0) {
                List<CharCount> l = init(words[i]);
                if (compare(list, l, words[i])) {
                    result++;            
                }
            }
        }
        
        return result;
    }
    
    public List<CharCount> init(String S) {
        List<CharCount> list = new ArrayList<>();
        if (S.length() == 0) return list;
        
        list.add(new CharCount(S.charAt(0), 1));
        int index = 0;
                 
        for (int i = 1; i < S.length(); i++) {
            CharCount curr = (CharCount)list.get(index);
            if (curr.c == S.charAt(i)) {
                curr.count++;
            } else {
                list.add(new CharCount(S.charAt(i), 1));
                index++;
            }
        }
        
        return list;
    }
    
    public boolean compare(List<CharCount> list, List<CharCount> l, String s) {
        if (list.size() != l.size()) return false;
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).c != l.get(i).c || 
                l.get(i).count > list.get(i).count ||
                (l.get(i).count != list.get(i).count && list.get(i).count < 3)) {
                    return false;
            }
        }
    
        return true;
    }
}
