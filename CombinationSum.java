/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.
*/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> set = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0 || target < 0) {
            return set;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> sum = new ArrayList<Integer>();
        
        combinationSum(set, sum, 0, candidates, target);
        
        return set;
    }
    
    void combinationSum(List<List<Integer>> set, ArrayList<Integer> sum, int start, int[] candidates, int target) {
        
        if(target == 0) {
            set.add((ArrayList)sum.clone());
            return;
        }
        
        for(int i=start; i<candidates.length; i++) {
            if(target - candidates[i] < 0) {
                break;
            }
            sum.add(candidates[i]);
            combinationSum(set, sum, i, candidates, target - candidates[i]);
            sum.remove(sum.size()-1);
        }
    }
}
