/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 0) {
            return new int[0][0];
        }
        
        int[][] mat = new int[n][n];
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n-1;
        int colEnd = n-1;
        
        int num = 1;
        int i = 0;
        int j = 0;
        
        while(rowStart <= rowEnd && colStart <= colEnd) {
            for(i=rowStart, j=colStart; j<=colEnd; j++) {
                mat[i][j] = num++;
            }
            rowStart++; 
            for(i=rowStart, j=colEnd; i<=rowEnd; i++) {
                mat[i][j] = num++;
            }
            colEnd--;
            for(i=rowEnd, j=colEnd; j>=colStart; j--) {
                mat[i][j] = num++;
            }
            rowEnd--;
            for(i=rowEnd, j=colStart; i>=rowStart; i--) {
                mat[i][j] = num++;
            }
            colStart++;
        }
        
        return mat;
    }
}
