/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 0)
            return "";
        if(numRows == 1) {
            return s;
        }
        
        int l = s.length();
        int r=numRows;
        int k=r+r-2;
        int j=0;
        int i=0;
        String zigzag = "";
        
        while(j < r) {
            i = 0;
            while(k * i - j < l) {
                if((j != 0) && (j != r-1)) {
                    zigzag += (k*i - j > 0) ? s.charAt(k * i - j) : "";
                }
                
                if(k*i + j < l) {
                    zigzag +=   s.charAt(k * i + j);
                }
                
                i++;
            }
            j++;
        }
        
        return zigzag;
    }
}
