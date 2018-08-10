/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
*/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        int longest = Integer.MAX_VALUE;
        String str = strs[0];
        int len = str.length();
        
        int j = 0;
        for(int i=0; i<strs.length; i++) {
            j = 0;
            int iLen = strs[i].length();
            while(j < longest && j < len && j < iLen && str.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            if(j < longest) {
                longest = j;
            }
        }
        
        if(longest == 0) {
            return "";
        } else {
            return str.substring(0, longest);
        }
    }
}
