/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
*/
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        
        if(nums == null) {
            return result;
        }
        
        int diff = 0;
        for(int i=0; i<nums.length; i++) {
            diff ^= nums[i];
        }
        
        int lowestOneBit = Integer.lowestOneBit(diff);
        
        for(int i=0; i<nums.length; i++) {
            if((lowestOneBit & nums[i]) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        
        return result;
    }
}
