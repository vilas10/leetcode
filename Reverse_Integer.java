/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public class Solution {
    public int reverse(int x) {
        
        int flag=0;
        long r=0;
        int c=1;
        
        if(x<0){
            flag=1;
            x=x*(-1);
        }
        
        while(x!=0){
            r *= 10;
            r += (x%10);
            if(r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
                return 0;
            }
            x=x/10;
        }
        
        if(flag==1){
            r=r*(-1);
        }
        
        return (int)r;
    }
}
