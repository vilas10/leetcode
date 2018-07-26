/*
We are given two strings, A and B.
A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
*/

class Solution {
    public boolean rotateString(String A, String B) {
        int len = A.length();
        
        if (A.length() != B.length()) return false;
        if (A.equals(B)) return true;
        
        for (int i = 0; i < A.length(); i++) {
            int k = i % len;
            String s = A.substring(i) + A.substring(0, i);
            
            if (s.equals(B)) return true;
        }
        
        return false;
    }
}
