
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] maxSub = new int[nums.length];
        int maxsum = nums[0];
        maxSub[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSub[i] = Math.max(maxSub[i-1] + nums[i], nums[i]);
            maxsum = Math.max(maxsum, maxSub[i]);        
        }
        
        return maxsum;
    }
}
