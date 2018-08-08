/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        HashMap<String, Integer> alphabet = new HashMap<String, Integer>();
        for(int i=0; i<26; i++) {
            alphabet.put(Character.toString ((char) (i + 65)), i+1);
        }
        
        int n = s.length();
        int num = 0;
        
        for(int i=n-1; i>=0; i--) {
            char c = s.charAt(i);
            num += Math.pow(26, n-i-1)*alphabet.get(""+c);
        }
        
        return num;
    }
}
