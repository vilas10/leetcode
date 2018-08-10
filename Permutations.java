/*
Given a collection of distinct integers, return all possible permutations.
*/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        permute(nums, nums.length-1, result);
        
        return result;
    }
    
    void permute(int[] nums, int end, List<List<Integer>> result) {
        
        if(end == 0) {
            List<Integer> l = new ArrayList<Integer>();
            l.add(nums[0]);
            result.add(l);
            return; 
        }
        
        permute(nums, end-1, result);
        List<List<Integer>> tempResult = new ArrayList<List<Integer>>(result);
        result.clear();
        for(List<Integer> perm: tempResult) {
            for(int i=0; i<=perm.size(); i++) {
                List<Integer> newPerm = new ArrayList<Integer>(perm);
                newPerm.add(i, nums[end]);
                result.add(newPerm);
            }
        }
    }
}
