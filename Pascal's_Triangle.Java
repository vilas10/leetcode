/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
*/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        if(numRows == 0) {
            return pascal;
        }
        
        List<Integer> currRow = new ArrayList<Integer>();
        List<Integer> prevRow = null;
        currRow.add(1);
        pascal.add(currRow);
        
        for(int i=1; i<numRows; i++) {
            prevRow = pascal.get(i-1);
            currRow = new ArrayList<Integer>();
            for(int j=0; j<=i; j++) {
                if(j == 0 || j == i) {
                    currRow.add(1);
                } else {
                    currRow.add(prevRow.get(j) + prevRow.get(j-1));
                }
            }
            pascal.add(currRow);
        }
        
        return pascal;
    }
}
