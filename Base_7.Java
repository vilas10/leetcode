/*
Given an integer, return its base 7 string representation.
*/
public class Solution {
    public String convertToBase7(int num) {
        String s = "";
        int next = 0;
        if (num == 0) {
            s = "0";
        } else if (num > 0) {
            next = num;
        } else {
            next = -1  * num;
            // s = "-" + s; 
        }
        
        while (next != 0) {
            s = next % 7 + s; 
            next = next / 7;
        }
        
        if (num < 0) return "-" + s;
        
        return s;
    }
}
