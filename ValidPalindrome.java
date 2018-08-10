/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null) {
            return false;
        }
        if(s.length() == 0 || s.length() == 1) {
            return true;
        }
        
        s=s.toLowerCase();
        char[] c=s.toCharArray();
        int b=0;
        int l=c.length-1;
        
        char sc='\0';
        char lc='\0';
        
        while(b<l){
            
            if(Character.isLetterOrDigit(c[b])){
                sc=c[b];
            }else{
                b++;
                continue;
            }
            
            if(Character.isLetterOrDigit(c[l])){
                lc=c[l];
            }else{
                l--;
                continue;
            }
            
            if(sc==lc){
                b++;
                l--;
            }else{
                return false;
            }
        }
        
        return true;
    }
}
