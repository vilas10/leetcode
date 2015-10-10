/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

/*  1. Brute force O(mxn)
    2. Looking for last element in last column once found the row, look for the element in the row O(m+n)
    3. Binary search: Look for target in last column using Binary Search, once found the row, binary search in the row O(logm + logn) = O(logmn)
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     if(matrix == null) {   
         return false;
     }
     
     if(matrix.length == 1) {
         return searchRow(matrix[0], target);
     }
     
     int row = findRow(matrix, target);
     
     return searchRow(matrix[row], target);
    }
    
    public int findRow(int[][] matrix, int target) {
        int col = matrix[0].length - 1;
        int l = 0;
        int r = matrix.length - 1;
        int m = 0;
        while(r-l > 1) {
            m = (l + r)/2;
            if(matrix[m][col] == target) {
                return m;
            } else if(matrix[m][col] > target) {
                r = m;
            } else {
                l = m;
            }
        }
        
        if(r == l) {
            return l;
        } else {
            if(target > matrix[l][col]) {
                return r;
            } else {
                return l;
            }
        }
    }
    
    public boolean searchRow(int[] row, int target) {
        int l = 0;
        int r = row.length - 1;
        int m = 0;
        
        while(r-l > 1) {
            m = (l + r)/2;
            if(row[m] == target) {
                return true;
            } else if(row[m] > target) {
                r = m;
            } else {
                l = m;
            }
        }
        
        if(target == row[l] || target == row[r]) {
            return true;
        } else {
            return false;
        }
    }
}
