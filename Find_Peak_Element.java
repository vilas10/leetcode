/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*/

public class Solution {
    public boolean flag = false;
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        if(nums.length == 1) {
            return 0;
        }
        
        int peak = 0;
        return peakElement(nums, 0, nums.length-1);
    }
    
    public int peakElement(int[] nums, int l, int r) {
        if(l == r) {
            flag = true;
            return l;
        }
        int m = (l+r)/2;
        
        if(m == 0) {
            flag = true;
            if(nums[m] > nums[m+1]) {
                return m;
            } else {
                return m+1;
            }
        } else if(m == nums.length-1) {
            flag = true;
            if(nums[m] > nums[nums.length-2]) {
                return m;
            } else {
                return m-1;
            }
        }
        
        int ret = 0;
        
        if(nums[m-1] < nums[m] && nums[m] < nums[m+1]) {
            ret = peakElement(nums, m+1, r);
        } else if(nums[m-1] > nums[m] && nums[m] > nums[m+1]) {
            ret = peakElement(nums, l, m-1);
        } else if(nums[m-1] > nums[m] && nums[m] < nums[m+1]) {
            ret = peakElement(nums, l, m-1);
        } else {
            ret = m;
            flag = true;
        }
        
        if(flag == true) {
            return ret;
        } else {
            return m;
        }
        
    }
}
