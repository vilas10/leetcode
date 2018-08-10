/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
*/
public class Sqrt(x) {
    public int mySqrt(int x) {
        
        if(x == 0 || x == 1) {
            return x;
        }
        
        int l = 1;
        int h = 1 + x/2;
        int m = 0;
        
        while(l < h) {
            m = l + (h-l)/2;
            
            if(m <= x/m) {
                l = m + 1;
            }
            else { 
                h = m;
            }
        }
        
        return l-1;
    }
}
