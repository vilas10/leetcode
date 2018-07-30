/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] newArray = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(newArray);
        
        int i = 0;
        while (i < nums.length && nums[i] == newArray[i]) i++;
        
        if (i == nums.length) return 0;
        
        int j = nums.length - 1;
        while (j >= 0 && nums[j] == newArray[j]) j--;
        
        return j - i + 1;
    }
}
