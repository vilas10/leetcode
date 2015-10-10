/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Update (2014-11-02):
The signature of the function had been updated to return the index instead of the pointer. 
If you still see your function signature returns a char * or String, 
please click the reload button  to reset your code definition.
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return -1; 
        }
        if(needle.equals("")) {
            return 0;
        }
        
        if(haystack.equals("")){
            return -1;
        }
        
        int begin = 0;
        int nlen = needle.length();
        int hlen = haystack.length();
        String str = "";
        int end = begin + nlen;
        
        while(end <= hlen) {
            str = haystack.substring(begin, end);
            if(needle.equals(str)) {
                return begin;
            }
            begin++;
            end = begin + nlen;
            
        }
        
        return -1;
    }
}
