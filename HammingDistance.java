/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance
*/

class HammingDistance {
    public int hammingDistance(int x, int y) {
        int ones = x ^ y;
        int count = 0;
        while(ones > 0) {
            ones = ones & (ones - 1);
            count++;
        }
        
        return count;
    }
}
