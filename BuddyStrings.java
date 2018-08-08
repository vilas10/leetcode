/*
Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
*/

class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int[] counts = new int[26];
        
        if (A.equals(B)) {
            for (int i = 0; i < A.length(); i++) {
                if (counts[A.charAt(i) - 'a'] > 0) return true;
                counts[A.charAt(i) - 'a']++;
            }
            
            return false;
        }
        
        int diff = 0;
        int diff1 = -1;
        int diff2 = -1;
        for (int i = 0; i < A.length(); i++) {
            counts[A.charAt(i) - 'a']++;
            counts[B.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) return false;
        }
        
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) diff++;
        }
        
        return diff <= 2;
    }
}
