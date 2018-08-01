/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.
*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetsOut = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return subsetsOut;
        }
        
        Arrays.sort(nums);
        List<Integer> sub = new ArrayList<Integer>();
        
        subsets(subsetsOut, sub, nums, 0);
        
        return subsetsOut;
    }
    
    void subsets(List<List<Integer>> subsetsOut, List<Integer> sub, int[] nums, int pos) {
        if(pos <= nums.length) {
            subsetsOut.add(sub);
        }
        
        int i = pos;
        
        while(i < nums.length) {
            sub.add(nums[i]);
            subsets(subsetsOut, new ArrayList<Integer>(sub), nums, i+1);
            sub.remove(sub.size() - 1);
            
            i++;
        }
    }
}
