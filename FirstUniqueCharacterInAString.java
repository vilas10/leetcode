/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
*/

class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s == "") return -1;
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            letters[c]++;
        }
        
        int i;
        for (i = 0; i < s.length() && letters[s.charAt(i) - 'a'] != 1; i++) {}
        
        if (i >= s.length()) return -1;
        
        return i;
    }
}
