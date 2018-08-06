/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/
/*  1. Using binary search, find the target. Once found, look for left and right extremes. O(logn + n)
    2. Using binary search, find the target, and using left and right, find the limits
*/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] limits = new int[]{-1, -1};
        
        if(nums == null || nums.length == 0) {
            return limits;
        }
        
        binarySearch(nums, target, 0, nums.length-1, limits);
        
        return limits;
    }
    
    void binarySearch(int[] nums, int target, int start, int end, int[] limits) {
        if(start > end) {
            return;
        }
        
        if(start == end && target != nums[start]) {
            return;         
        }
        
        int mid = (start+end)/2;
        
        if(target == nums[mid]) {
            if(limits[0] == -1 || limits[0] > mid) {
                limits[0] = mid;
                binarySearch(nums, target, start, mid-1, limits);
            }
            
            if(limits[1] == -1 || limits[1] < mid) {
                limits[1] = mid;
                binarySearch(nums, target, mid+1, end, limits);
            }
        } else if(target < nums[mid]) {
            binarySearch(nums, target, start, mid, limits);
        } else {
            binarySearch(nums, target, mid+1, end, limits);
        }
        
        return;
    }
}
