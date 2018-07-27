/*
Write a program to check whether a given number is an ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
*/

public class Solution {
    public boolean isUgly(int num) {
        if(num < 1) {
            return false;
        }
        double n = num;
    
        while(n % 2 == 0) {
            n /= 2;
        }
        
        while(n % 3 == 0) {
            n /= 3;
        }
        
        while(n % 5 == 0) {
            n /= 5;
        }
        
        if(n == 1) {
            return true;
        } else {
            return false;
        }
    }
}
