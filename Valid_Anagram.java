/^
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
*/

public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<s.length(); i++) {
            String curr = s.charAt(i) + "";
            if(map.containsKey(curr)) {
                map.put(curr, map.get(curr) + 1);
            } else {
                map.put(curr, 1);
            }
        }
        
        for(int i=0; i<t.length(); i++) {
            String curr = t.charAt(i) + "";
            if(map.containsKey(curr)) {
                int count = map.get(curr);
                if(count - 1 == 0) {
                    map.remove(curr);
                } else {
                    map.put(curr, count - 1);
                }
            } else {
                return false;
            }
        }
        
        return true;
    }
}
