/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class Solution {
    public String addBinary(String a, String b) {
        String sum = "";
        int alen = a.length();
        int blen = b.length();
        int max = alen > blen ? alen : blen;
        int c = 0;
        int s = 0;
        int aval = 0;
        int bval = 0;
        while(max > 0) {
            if(alen > 0) {
                aval = a.charAt(alen-1) - '0';
            }else{
                aval=0;
            }
            
            if(blen > 0) {
                bval = b.charAt(blen-1) - '0';
            }else{
                bval=0;
            }
            
            s = (aval + bval + c) % 2;
            c = (aval + bval + c) / 2;
            
            sum = s + "" + sum;
            max--;
            alen--;
            blen--;
        }
        if(c == 1) {
            sum = "1" + sum;
        }
        return sum;
    }
}
