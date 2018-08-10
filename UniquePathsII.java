/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

*/
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[rows-1][cols-1] == 1) {
            return 0;
        }
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;
        for(int i=1, j=0; i<rows; i++) {
            if(obstacleGrid[i][j] == 1) {
                break;
            }
            
            dp[i][j] = 1;
        }
        
        for(int i=0, j=1; j<cols; j++) {
            if(obstacleGrid[i][j] == 1) {
                break;
            }
            
            dp[i][j] = 1;
        }
        
        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                if(obstacleGrid[i][j] == 1) {
                    continue;
                }
                
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[rows-1][cols-1];
    }
}
