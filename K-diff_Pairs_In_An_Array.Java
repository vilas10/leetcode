/*
Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
*/
class Solution {
    public int findPairs(int[] nums, int k) {
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            if (i == j) {
                j++;
                continue;
            }
            
            int diff = Math.abs(nums[i] - nums[j]);
            if (diff == k) {
                if (!set.contains(nums[j] + "," + nums[i])) 
                    set.add(nums[i] + "," + nums[j]);
                i++; j++;
            } else if (diff < k) {
                j++;
            } else {
                i++;
            }
        }
        
        return set.size();
    }
}
