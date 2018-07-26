/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

/* Moore's Voting Algorithm */

public class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int majority_index = 0;
        int count = 1;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[majority_index] == nums[i]) {
                count++;
            } else {
                count--;
            }
            
            if(count == 0) {
                majority_index = i;
                count = 1;
            }
        }
        
        return nums[majority_index];
    }
}
