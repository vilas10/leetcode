/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
*/
public class Solution {
    public int numSquares(int n) {
        if(n <= 0) {
            return 0;
        }
        
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        
        for(int i=1; i<=n; i++) {
            int sqrt = (int)Math.sqrt(i);
            if(i == sqrt*sqrt) {
                dp[i] = 1;
                continue;
            }
            for(int j=1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1); 
            }
        }
        
        return dp[n];
    }
}
