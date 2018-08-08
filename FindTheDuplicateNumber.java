/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
*/
class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        BitSet bits = new BitSet(nums.length - 1);
        int i = 0;
        for (; i < nums.length; i++) {
            if (bits.get(nums[i])) break;
            
            bits.set(nums[i]);
        }
        
        return nums[i];
    }
}
