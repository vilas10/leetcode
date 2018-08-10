/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
*/

public class NumArray {
    
    private int[] dp;
    
    public NumArray(int[] nums) {
        if(nums != null && nums.length > 0) {
            dp = new int[nums.length+1];
            dp[0] = 0;
            for(int i=1; i<dp.length; i++) {
                dp[i] = dp[i-1] + nums[i-1];
            }
        } else {
            dp = null;
        }
        
    }

    public int sumRange(int i, int j) {
        if(dp == null) {
            return 0;
        }
        
        return dp[j+1] - dp[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
