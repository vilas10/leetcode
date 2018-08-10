/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
*/
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
       if(nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        if(nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        
        int[] majorityIndex = new int[2];
        int[] count = new int[2];
        
        majorityIndex[0] = -1;
        majorityIndex[1] = -1;
        
        for(int i=0; i<nums.length; i++) {
            if(majorityIndex[0] != -1 && nums[majorityIndex[0]] == nums[i]) {
                count[0]++;
            } else if(majorityIndex[1] != -1 && nums[majorityIndex[1]] == nums[i]) {
                count[1]++;
            } else if(count[0] == 0) {
                majorityIndex[0] = i;
                count[0] = 1;
            } else if(count[1] == 0) {
                majorityIndex[1] = i;
                count[1] = 1;
            } else {
                count[0]--;
                count[1]--;
            }
        }
        
        count[0] = count[1] = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == nums[majorityIndex[0]]) {
                count[0]++;
            } else if(nums[i] == nums[majorityIndex[1]]) {
                count[1]++;
            }
        }
        
        if(count[0] > nums.length/3) {
                result.add(nums[majorityIndex[0]]);
        } 
        if(count[1] > nums.length/3) {
                result.add(nums[majorityIndex[1]]);
        }
        
        return result;
    }
}
