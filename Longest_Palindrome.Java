/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.
*/

public class Solution {
    public int longestPalindrome(String s) {
        boolean[] alpha = new boolean[256];
        int count = 0;
        
        for (int i=0; i< s.length(); i++) {
            if (alpha[s.charAt(i)]) {
                count++;
                alpha[s.charAt(i)] = false;
            } else { 
                alpha[s.charAt(i)] = true;
            }
        }
        
        if (count * 2 < s.length())
            return 2 * count + 1;
        else
            return 2 * count;
    }
}
