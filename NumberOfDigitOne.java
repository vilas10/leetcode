/*
https://leetcode.com/submissions/detail/52542581/
*/
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        if(n <= 0) {
            return 0;
        }
        
        long r = 0;
        long m = 0;
        int ones = 0;
        
        for(long k=1; k<=n; k *= 10) {
            r = n/k;
            m = n%k;
            
            ones += (r+8)/10 * k + (r%10 == 1 ? m+1:0);
        }
        
        return ones;
    }
}
