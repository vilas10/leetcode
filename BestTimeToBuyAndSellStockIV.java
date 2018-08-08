/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
*/
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        
        if(k > prices.length/2) {
            int profit = 0;
            for(int i=1; i<prices.length; i++) {
                if(prices[i] > prices[i-1]) {
                    profit += prices[i] - prices[i-1];
                }
            }
            
            return profit;
        }
        
        int[] dp = new int[prices.length];
        
        for(int t=1; t<=k; t++) {
            int temp = dp[0] - prices[0];
            for(int i=1; i<prices.length; i++) {
                temp = Math.max(temp, dp[i] - prices[i]);
                dp[i] = Math.max(dp[i-1], temp + prices[i]);
            }
        }
        
        return dp[prices.length - 1];
    }
}
