/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.
*/
public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int negProd = 0;
        int lastProd = nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
        if (nums[0] < 0 && nums[1] < 0) negProd = nums[0] * nums[1];
        
        
        if (negProd * nums[nums.length-1] > lastProd) {
            return negProd * nums[nums.length-1];
        } else {
            return lastProd;
        }
    }
}
