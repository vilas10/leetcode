/*
https://leetcode.com/problems/coin-change/description/
*/
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null) {
            return -1;
        }
        if(amount <= 0) {
            return 0;
        }
        
        //Arrays.sort(coins);
        
        int[] dp = new int[amount+1];
        int sum = 1;
        
        while(sum <= amount) {
            int min = -1;
            for(int coin: coins) {
                
                if(sum >= coin && dp[sum-coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    if(min == -1) {
                        min = temp;
                    } else {
                        if(min > temp) {
                            min = temp;
                        } 
                    }
                } 
            }
            
            dp[sum] = min;
            sum++;
        }
        
        return dp[amount];
    }
}
