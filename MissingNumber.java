/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/

public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;
        double expected = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(min >= nums[i]) {
                min = nums[i];
            }
            
            if(max <= nums[i]) {
                max = nums[i];
            }
            
            sum += nums[i];
        }
        if(min != 0) {
            return 0;
        } else if(max != nums.length) {
            return max+1;
        }
        
        expected = (1 + nums.length) * (min + max)/2;
        
        return (int)(expected - sum);
    }
}
