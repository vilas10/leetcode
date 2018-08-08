/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.
*/

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int i = 1;
        
        for (; n > 0; i++, n = n - i) {}
        
        // if (n == 0) 
        //     return i-1;
        // else 
        //     return i;
        return i-1;
    }
}
