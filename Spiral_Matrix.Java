/*
https://leetcode.com/problems/spiral-matrix/description/
*/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<Integer>();
        
        if(matrix == null || matrix.length == 0) {
            return spiral;
        }
        
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length-1;
        int colEnd = matrix[0].length-1;
        
        int i = 0;
        int j = 0;
        
        while(rowStart <= rowEnd && colStart <= colEnd) {
            for(i=rowStart, j=colStart; j<=colEnd; j++) {
                spiral.add(matrix[i][j]);
            }
            rowStart++; 
            for(i=rowStart, j=colEnd; i<=rowEnd; i++) {
                spiral.add(matrix[i][j]);
            }
            colEnd--;
            if(rowStart <= rowEnd) {
                for(i=rowEnd, j=colEnd; j>=colStart; j--) {
                    spiral.add(matrix[i][j]);
                }
                rowEnd--;
            }
            
            if(colStart <= colEnd) {
                for(i=rowEnd, j=colStart; i>=rowStart; i--) {
                    spiral.add(matrix[i][j]);
                }
                colStart++;
            }
        }
        
        return spiral;
    }
}
