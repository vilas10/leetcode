/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        int[] prod = new int[nums.length];
        int[] minprod = new int[nums.length];
        
        prod[0] = nums[0];
        minprod[0] = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            int prev = nums[i-1]*nums[i];
            int pmin = minprod[i-1]*nums[i];
            int pmax = prod[i-1]*nums[i];
            minprod[i] = Math.min(nums[i], Math.min(prev, Math.min(pmin, pmax)));
            prod[i] = Math.max(nums[i], Math.max(prev, Math.max(pmin, pmax)));
        }
        int result = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(result < prod[i]) {
                result = prod[i];
            } 
        }
        
        return result;
    }
}
