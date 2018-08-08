/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
*/

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();        
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int n1 = 0;
        int n2 = 0;
        
        while (i >= 0 || j >= 0 || carry == 1) {
            n1 = i < 0 ? 0 : ((int)num1.charAt(i--) - '0');
            n2 = j < 0 ? 0 : ((int)num2.charAt(j--) - '0');

            int sum = n1 + n2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        
        return result.reverse().toString();
    }
}
