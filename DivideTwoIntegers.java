/*
https://leetcode.com/problems/divide-two-integers/description/
*/
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        if(divisor == 1) {
                return dividend;
        }
        
        if(dividend == Integer.MIN_VALUE) {
            if(divisor == -1) {
                return Integer.MAX_VALUE;
            } else if((divisor & 1) == 1) {
                return divide(dividend + 1, divisor);
            } else {
                return divide(dividend >> 1, divisor >> 1);
            }
        }
        
        if(divisor == Integer.MIN_VALUE) {
            return 0;
        }
        
        int sign = ((divisor > 0) ^ (dividend > 0)) ? -1 : 1;
        
        int divd = Math.abs(dividend);
        int divs = Math.abs(divisor);
        int quotient = 0;
        while(divd >= divs) {
            int temp = divs;
            int multiple = 1;
            
            while(divd >= (temp << 1) && ((temp << 1) > divs)) {
                temp <<= 1;
                multiple <<= 1;
            }
            
            divd -= temp;
            quotient += multiple;
        }
        
        if(sign == 1) { 
            return quotient;
        } else {
            return -quotient;
        }
    }
}
