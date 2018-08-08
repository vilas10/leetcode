/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
*/

public class BestTimeToBuyAndSellStockII {
    
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        
        for(int i=0;i<prices.length;i++){
            if(minprice > prices[i]){
                minprice=prices[i];
                continue;
            }
            
            if(i+1 != prices.length) {
                if(prices[i] < prices[i+1]) {
                    continue;
                }
            }
            
            maxprofit += prices[i] - minprice;
            minprice = Integer.MAX_VALUE;
        }
        
        return maxprofit;
    }
    
}
