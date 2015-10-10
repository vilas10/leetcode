/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null) {
            return null;
        }
        
        int[] plusone = null;
        int carry = 0;
        int plus = 1;
        int sum = 0;
        
        for(int i = digits.length-1; i >= 0; i--) {
            sum = (digits[i] + plus + carry)%10;
            carry = (digits[i] + plus + carry)/10;
            digits[i] = sum;
            plus = 0;
        }
        
        if(carry == 1) {
            plusone = new int[digits.length + 1];
            plusone[0] = carry;
            plus = 1;
        } else {
            plusone = new int[digits.length];
            plus = 0;
        }
        
        for(int i = 0; i<digits.length; i++) {
            plusone[i+plus] = digits[i];
        }
        
        return plusone;
    }
}
