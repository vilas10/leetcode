/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int longest = 0;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            String curr = s.charAt(i) + "";
            
            if (!map.containsKey(curr)) {
                map.put(curr, i);
            } else {
                int index = map.get(curr);
                
                for (int j=start; j <= index ; j++) {
                    map.remove(s.charAt(j) + "");
                }
                
                start = index + 1;
                map.put(curr, i);
            }
            
            if (longest < map.size()) {
                longest = map.size();
            }
        }
        
        return longest;
    }
}
