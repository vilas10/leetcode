/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
Note that the row index starts from 0.
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pascal = new ArrayList<Integer>();
        if(rowIndex < 0) {
            return pascal;
        }
        List<Integer> prev = null;
        
        pascal.add(1);
        
        for(int i=1; i <= rowIndex; i++) {
            prev = pascal;
            pascal = new ArrayList<Integer>();
            for(int j=0; j <= i; j++) {
                if(j == 0 || j == i) {
                    pascal.add(1);
                } else {
                    pascal.add(prev.get(j) + prev.get(j-1));
                }
            }
        }
        
        return pascal;
    }
}
