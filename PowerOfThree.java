/*
Given an integer, write a function to determine if it is a power of three.
*/

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n == 0) {
            return false;
        }
        double pow = Math.log10(n)/Math.log10(3);
        
        return Math.pow(3, (int)pow) == n;
    }
}
