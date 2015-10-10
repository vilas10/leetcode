/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0 || nums.length == 1) {
            return null;
        }
        
        int flag = 0;
        
        HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            set.put(nums[i], i+1);
        }
        
        for(int i=0; i<nums.length; i++) {
            if(set.containsKey(target - nums[i])) {
                result[0] = i+1;
                result[1] = set.get(target - nums[i]);
                if(result[0] != result[1])
                    break;
            }
        }
        
        return result;
    }
}
