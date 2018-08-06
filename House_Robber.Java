/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
*/
public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int[] df = new int[nums.length];
        int[] dl = new int[nums.length];
        int i = 0;
        
        df[0] = 0;
        df[1] = nums[0];
        
        for(i=2; i<df.length; i++) {
            df[i] = Math.max(df[i-1], df[i-2] + nums[i-1]);
        }
        
        dl[0] = 0;
        dl[1] = nums[1];
        
        for(i=2; i<dl.length; i++) {
            dl[i] = Math.max(dl[i-1], dl[i-2] + nums[i]);
        }
        
        return Math.max(df[i-1], dl[i-1]);
    }
}
