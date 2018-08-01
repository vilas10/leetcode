/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> set = new ArrayList<List<Integer>>();
        if(k == 0 || n == 0) {
            return set;
        }
        
        ArrayList<Integer> sum = new ArrayList<Integer>();
        
        combinationSum3(set, sum, k, 1, n);
        
        return set;
    }
    
    void combinationSum3(List<List<Integer>> set, ArrayList<Integer> sum, int k, int start, int n) {
        if(k == 0) {
            if(n == 0) {
                set.add((ArrayList)sum.clone());
            }
            return;
        }
        
        for(int i=start; i<=9; i++) {
            if(n - i < 0) {
                break;
            }
            
            sum.add(i);
            combinationSum3(set, sum, k-1, i+1, n-i);
            sum.remove(sum.size() - 1);
        }
    }
}
