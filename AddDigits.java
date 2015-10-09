/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
*/

public class AddDigits {
    /*public int addDigits(int num) {
        int sum = 0;
        
        while(num != 0) {
            sum += num % 10;
            num /= 10;
            if(num == 0) {
                if(sum >= 10) {
                    num = sum;
                    sum = 0;
                }
            }
        }
        
        return sum;
    }*/
    
    public int addDigits(int num) {
        int temp = (num-1)/9;
        return num - 9*temp;
    }
}
