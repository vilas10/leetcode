/*
Given an integer, write a function to determine if it is a power of two.
*/
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        
        while(n > 2) {
            int right = n >> 1;
            int left = right << 1;
            
            if(n != left) {
                return false;
            }
            
            n = n >> 1;
        }
        
        return true;
    }
}
