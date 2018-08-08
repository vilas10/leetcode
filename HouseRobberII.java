/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself 
a new place for his thievery so that he will not get too much attention. 
This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class HouseRobberII {
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
