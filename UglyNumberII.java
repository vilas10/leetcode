/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if(n <= 0) {
            return 0;
        }
        
        int[] ugly = new int[n];
        int dp2 = 0, dp3 = 0, dp5 = 0;
        int mul2 = 2, mul3 = 3, mul5 = 5;
        int min = 1;
        
        ugly[0] = 1;
        
        for(int i=1; i<n; i++) {
            min = Math.min(Math.min(mul2, mul3), mul5);
            ugly[i] = min;
            
            if(min == mul2) {
                dp2++;
                mul2 = 2*ugly[dp2];
            }
            if(min == mul3) {
                dp3++;
                mul3 = 3*ugly[dp3];
            }
            if(min == mul5) {
                dp5++;
                mul5 = 5*ugly[dp5];
            }
        }
        
        return min;
    }
}
