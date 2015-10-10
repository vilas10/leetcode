/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) {
            return null;
        }
        
        char[] prev = { '1' };
        
        int counter = 1;
        int k = 1;
        
        if(n == k) {
            return "1";
        }
        
        String curr = "";
        
        while(k < n){
            curr = "";
            
            for(int i=0; i<prev.length; i++) {
                
                while(i != prev.length-1 && prev[i] == prev[i+1]) {
                    counter++;
                    i++;
                }
                
                curr += (counter + "" + prev[i]);
                counter = 1;
            }
            
            k++;
            prev = curr.toCharArray();
        }
        
        return curr;
    }
}
