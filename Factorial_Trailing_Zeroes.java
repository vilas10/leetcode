/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

public class Solution {
    public int trailingZeroes(int n) {
        if(n <= 0) {
            return 0;
        }    
        int k = 1;
        int count = 0;
        
        while(Math.pow(5,k) <= n) {
            count += n/Math.pow(5,k);
            k++;
        }
        
        return count;
    }
}
