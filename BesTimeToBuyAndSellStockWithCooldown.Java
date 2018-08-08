/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
*/
public class BesTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        
        int buy0 = -prices[0];
        int buy1 = buy0, sell0 = 0, sell1 = 0, sell2 = 0;
        
        for(int i=0; i<prices.length; i++) {
            buy0 = Math.max(buy1, sell2 - prices[i]);
            sell0 = Math.max(sell1, buy1 + prices[i]);
            buy1 = buy0;
            sell2 = sell1;
            sell1 = sell0;
        }
        
        return Math.max(buy0, sell0);
    }
}
