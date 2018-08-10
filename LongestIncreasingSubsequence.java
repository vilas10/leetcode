/*
Given an unsorted array of integers, find the length of longest increasing subsequence.
*/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        for(int i=0; i<dp.length; i++) {
            dp[i] = 1;
        }
        
        
        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        int max = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        
        return max;
    }
}
