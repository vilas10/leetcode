/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        
        int[] product = new int[num1.length() + num2.length()];
        
        for(int i=num1.length()-1; i >= 0; i--) {
            int carry = 0;
            for(int j=num2.length()-1; j >= 0; j--) {
                int p = product[i+j+1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                product[i+j+1] = p%10;
                carry = p/10;
            }
            product[i] += carry;
        }
        
        int startpos = 0;
        while(startpos < product.length-1 && product[startpos] == 0) {
            startpos++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=startpos; i < product.length; i++) {
            sb.append(product[i]);
        }
        
        return sb.toString();
    }
}
