/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.
*/
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        
        int l = 0;
        int r = len-1;
        
        while(l < r) {
            int m = l + (r-l)/2;
            
            if(m > 0 && nums[m] < nums[m-1]) {
                return nums[m];
            }
            
            if(nums[m] >= nums[l] && nums[m] > nums[r]) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        
        return nums[l];
    }
}
