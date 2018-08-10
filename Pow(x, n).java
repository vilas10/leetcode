/*
https://leetcode.com/problems/powx-n/description/
*/
public class Pow(x, n) {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(x == 1) {
            return x;
        }
        if(x == -1) {
            return x*((n%2 == 0)? -1: 1);
        }
        boolean neg = false;
        if(n < 0) {
            neg = true;
            n *= -1;
        }
        double pow = 1;
        
        //pow = recPow(x, n);
        while(n > 0) {
            pow *= x;
            if(pow == 0) {
                break;
            }
            n--;
        }
        
        if(neg) {
            if(pow == 0) {
                return Double.MAX_VALUE;
            }
            return 1/pow;
        } else {
            return pow;
        }
    }
    
    public double recPow(double x, int n) {
        if(n == 1) {
            return x;
        }
        if(n == 0) {
            return 1;
        }
        double pow1 = 0;
        double pow2 = 0;
        if(n % 2 == 0) {
            return recPow(x, n/2) * recPow(x, n/2);
        } else {
            return recPow(x, n/2) * recPow(x, n/2 + 1);
        }
    }
}
