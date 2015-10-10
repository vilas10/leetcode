/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashMap<String, Integer> roman = new HashMap<String, Integer>();

        int l = s.length();
        int res = convert(s.charAt(l-1));
        
        if(l == 1) {
            return res;
        }
        int prev = 0;
        int curr = 0;
        while(l > 1) {
            prev = convert(s.charAt(l-2));
            curr = convert(s.charAt(l-1));
            if( prev >= curr) {
                res += prev;
            } else {
                res -= prev;
            }
            l--;
        }
        
        return res;
    }
    
    public int convert(char roman) {
        switch(roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
