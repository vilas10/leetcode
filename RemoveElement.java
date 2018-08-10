/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int l = nums.length;
        
        for(int i=0;i<l;i++) {
            if(nums[i] == val) {
                nums[i] = nums[l-1];
                nums[l-1] = val-1;
                l--;
                i--;
            }
        }
        
        return l;
    }
}
