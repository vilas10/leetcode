/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

*/

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] sum = new int[r][c];
        int maxarea = 0;
        
        for(int i=0; i<c; i++) {
            sum[0][i] = matrix[0][i];
            if(maxarea < sum[0][i]) {
                maxarea = sum[0][i];
            }
        }
        
        for(int j=0; j<r; j++) {
            sum[j][0] = matrix[j][0];
            if(maxarea < sum[j][0]) {
                maxarea = sum[j][0];
            }
        }
        
        for(int i=1; i<r; i++) {
            for(int j=1; j<c; j++) {
                if(matrix[i][j] == 49) {
                    sum[i][j] = Math.min(sum[i-1][j-1], Math.min(sum[i-1][j], sum[i][j-1])) + 1;
                } else {
                    sum[i][j] = 48;
                }
                
                if(maxarea < sum[i][j]) {
                        maxarea = sum[i][j];
                }
            }
        }
        
        return (maxarea-48)*(maxarea-48);
    }
}
