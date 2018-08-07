/*
https://leetcode.com/problems/nth-magical-number/description/
*/
class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        int lcm = (A * B) / gcd(A, B);
        System.out.println("lcm=" + lcm);
        int multiples = lcm / A + lcm / B - 1;
        
        System.out.println("multiples=" + multiples);

        long magic =  (N / multiples) * (long) lcm ;
        if (N % multiples == 0) return (int) (magic % 1000000007L);
        
        System.out.println("magic=" + magic);

        int extra = N % multiples;
        System.out.println("extra=" + extra);

        return (int)(extraMagic(magic, extra, A, B) % 1000000007L);
    }
    
    public int gcd(int a, int b) {        
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        return gcd(a, b - a);
    }
    
    public long extraMagic(long magic, int extra, int A, int B) {
        long mulsA = magic;
        long mulsB = magic;
        while (extra > 0) {
            if (mulsA + A < mulsB + B) {
                mulsA += A;
            } else {
                mulsB += B;
            }
            extra--;
        }
        
        return mulsA > mulsB ? mulsA : mulsB;
    }
}
