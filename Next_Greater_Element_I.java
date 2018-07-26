/*
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int start = 0;
        
        for (int i = 0; i < nums2.length - 1; i++) {
            if (nums2[i] < nums2[i+1]) {
                int k = i;
                for (; k >= start && nums2[k] < nums2[i+1]; k--) if (!map.containsKey(nums2[k])) map.put(nums2[k], nums2[i+1]);
                
                if (k < start) start = i+1;
            }
        }
        
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return nums1;
    }
}
