/*
https://leetcode.com/submissions/detail/51840642/
*/
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        
        int numOfTransactions = 2;
        int[][] dp = new int[numOfTransactions+1][prices.length];
        
        for(int t=1; t<=numOfTransactions; t++) {
            int temp = dp[t-1][0] - prices[0];
            for(int i=1; i<prices.length; i++) {
                dp[t][i] = Math.max(dp[t][i-1], temp + prices[i]);
                temp = Math.max(temp, dp[t-1][i] - prices[i]);
            }
        }
        
        return dp[numOfTransactions][prices.length - 1];
    }
}
