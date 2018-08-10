/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

*/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()) {
            return 0;
        }
        
        int tSize = triangle.size();
        int bottomRowSize = triangle.get(tSize-1).size(); 
        int[] dp = new int[bottomRowSize];
        
        for(int i=0; i<bottomRowSize; i++) {
            dp[i] = triangle.get(tSize-1).get(i);
        }
        
        for(int k=tSize-2; k >= 0; k--) {
            ArrayList<Integer> t = ((ArrayList<Integer>)triangle.get(k));
            
            for(int i=0; i<=k; i++) {
                dp[i] = Math.min(dp[i], dp[i+1]) + t.get(i);
            }
            
        }
        
        return dp[0];
    }
}
