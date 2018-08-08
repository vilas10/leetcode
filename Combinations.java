/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
*/
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combis = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0) {
            return combis;
        }
        
        ArrayList<Integer> combi = new ArrayList<Integer>();
        combine(combis, combi, n, 1, k, 0);
        
        return combis;
    }
    
    void combine(List<List<Integer>> combis, ArrayList<Integer> combi, int n, int start, int k, int len) {
        if(k == len) {
            combis.add((ArrayList)combi.clone());
            return;
        }
        
        for(int i=start; i<=n; i++) {
            combi.add(i);
            combine(combis, combi, n, i+1, k, len+1);
            combi.remove(len);
        }
    }
}
