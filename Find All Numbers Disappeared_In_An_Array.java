/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && nums[i] != (i+1)) {
                int temp = nums[i];
                
                if (nums[i] != nums[temp - 1]) {
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                    i--;
                } else {
                    nums[i] = 0;
                }
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) result.add(i + 1);
        }
        
        return result;
    }
}
