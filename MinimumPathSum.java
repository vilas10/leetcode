/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        
        for(int i=1, j=0; i<rows; i++) {
            dp[i][j] = dp[i-1][j] + grid[i][j];
        }
        
        for(int i=0, j=1; j<cols; j++) {
            dp[i][j] = dp[i][j-1] + grid[i][j];
        }
        
        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[rows-1][cols-1];
    }
}
