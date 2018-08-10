/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
*/

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        
        int div = 1;
        while(x/div >= 10) {
            div *= 10;
        }
        
        int right = 0;
        int left = 0;
        int temp = x;
        while(temp != 0) {
            right = temp/div;
            left = temp%10;
            
            if(right != left) {
                return false;
            }
            
            temp = temp%div;
            temp = temp/10;
            div = div/100;
        }
        
        return true;
    }
}
