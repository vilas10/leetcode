/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int zIndex = -1;
        int zCount = 0;
        
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) {
                if(zIndex < 0) {
                    zIndex = i;
                }
                zCount++;
            } else {
                if(zCount > 0) {
                    nums[zIndex] = nums[i];
                    zIndex++;
                }
            }
        }
        
        while(zCount > 0) {
            nums[nums.length - zCount] = 0;
            zCount--;
        }
    }
}
