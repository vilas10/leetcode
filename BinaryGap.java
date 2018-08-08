/*
Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.

If there aren't two consecutive 1's, return 0.
*/

class BinaryGap {
    public int binaryGap(int N) {
        int gap = 0;
        int maxgap = 0;
        boolean found = false;
        while (N > 0) {
            int bit = (N & 1);
            
            if (bit == 1) {
                if (found) {
                    gap++;
                    maxgap = Math.max(gap, maxgap);
                }
                found = true;
                gap = 0;
            } else if (found) {
                gap++;
            }
            
            N = N >> 1;
        }
        
        return maxgap;
    }
}
