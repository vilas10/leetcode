/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
*/
class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        if (num == 0) return bits;
        bits[1] = 1;
        if (num == 1) return bits;
        
        int div = 1;
        
        for (int i = 2; i <= num; i++) {
            if (div * 2 == i) {
                div *= 2;
            }
            
            bits[i] = 1 + bits[i % div];
        }
        
        return bits;
    }
}
