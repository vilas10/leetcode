/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.
*/

public class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;
        int len = nums.length;
        
        if (len == 1) return nums[0];
        
        for(int i=0; i< len/2; i++) {
            result ^= nums[i] ^ nums[len - 1 - i] ;
        }
        
        return result ^ nums[len/2];
    }
}
