/*
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
*/

class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) return nums;
        
        int rows = nums.length;
        int cols = nums[0].length;
        
        if (r * c !=  rows * cols || (r == rows && c == cols)) return nums;
        
        int[][] result = new int[r][c];
        int p = 0, q = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[p][q] = nums[i][j];
                
                if (q < c) q++; 
                if (q == c) {
                    q = 0;
                    p++;
                } 
            }
        }
        
        return result;
    }
}
