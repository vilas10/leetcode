/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return trim(S).equals(trim(T));
    }
    
    public String trim(String S) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                sb.append(S.charAt(i));
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
        return sb.toString();
    }
}
