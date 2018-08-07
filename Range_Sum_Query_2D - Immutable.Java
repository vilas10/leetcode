/*
https://leetcode.com/problems/range-sum-query-2d-immutable/description/
*/
public class NumMatrix {
    private int[][] dp = null;
    public NumMatrix(int[][] matrix) {
        if(matrix != null && matrix.length != 0) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            dp = new int[rows][cols];
            
            dp[0][0] = matrix[0][0];
            
            for(int i=1, j=0; i<rows; i++) {
                dp[i][j] = dp[i-1][j] + matrix[i][j]; 
            }
            
            for(int i=0, j=1; j<cols; j++) {
                dp[i][j] = dp[i][j-1] + matrix[i][j]; 
            }
            
            for(int i=1; i<rows; i++) {
                for(int j=1; j<cols; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] + matrix[i][j] - dp[i-1][j-1];
                }
            }
        }
        
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(dp == null) {
            return 0;
        }
        int left = 0, top = 0, corner = 0;
        if(col1-1 >= 0) {
            left = dp[row2][col1-1];
        }
        
        if(row1-1 >= 0) {
            top = dp[row1-1][col2];
        }
        
        if(col1-1 >= 0 && row1-1 >= 0) {
            corner = dp[row1-1][col1-1];
        }
        return dp[row2][col2] - left - top + corner;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
