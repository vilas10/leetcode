/*
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
*/

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        long expectedSum = nums.length * (nums.length + 1)/2;
        long actualSum = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                result[0] = nums[i];
            }
            
            set.add(nums[i]);
            actualSum += nums[i];
        }
        
        int diff = (int)(expectedSum - actualSum);
        result[1] = result[0] + diff;
        
        return result;
    }
}
