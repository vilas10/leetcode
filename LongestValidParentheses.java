/*
https://leetcode.com/problems/longest-valid-parentheses/description/
*/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s == null) {
            return 0;
        }
        
        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length];
        int open = 0;
        int max = 0;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == '(') {
                open++;
            }
            
            if(arr[i] == ')' && open > 0) {
                dp[i] = dp[i-1] + 2;
                
                if((i - dp[i]) > 0) {
                    dp[i] += dp[i-dp[i]];
                }
                open--;
            }
            
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        
        
        return max;
    }
}
