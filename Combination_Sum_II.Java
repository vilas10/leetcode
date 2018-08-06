/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        
        int removed = -1;
        for(int i=start; i<candidates.length; i++) {
            if(removed == candidates[i]) {
                continue;
            }
            if(target - candidates[i] < 0) {
                break;
            }
            
            
            sum.add(candidates[i]);
            combinationSum(set, sum, i+1, candidates, target - candidates[i]);
            removed = sum.remove(sum.size()-1);
            
        }
    }
}
