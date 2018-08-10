/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums == null) {
            return -1;
        }
        
        int l = 0;
        int r = nums.length-1;
        int m = (l+r)/2;
        
        if(target <= nums[l]) {
            return l;
        }
        
        if(target == nums[r]) {
            return r;
        }
        
        if(target > nums[r]) {
            return r+1;
        }
        
        while(r-l > 1) {
            m = (l+r)/2;
            if(target == nums[m]) {
                return m;
            } else if(target < nums[m]) {
                r = m;
            } else {
                l = m;
            }
        }
        
        return r;
    }
}
