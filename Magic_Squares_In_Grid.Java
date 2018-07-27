/*
A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
*/

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int count = 0;
        
        int[] arr = new int[16];
        boolean flag = true;
        
        for (int i = 1; i <= grid.length - 2; i++) {
            for (int j = 1; j <= grid[0].length - 2; j++) {
                
                arr[grid[i-1][j-1]]++;  arr[grid[i-1][j]]++;    arr[grid[i-1][j+1]]++;
                arr[grid[i][j-1]]++;    arr[grid[i][j]]++;      arr[grid[i][j+1]]++;
                arr[grid[i+1][j-1]]++;  arr[grid[i+1][j]]++;    arr[grid[i+1][j+1]]++;
                
                for (int k = 1; k <= 9; k++) {
                    if (arr[k] != 1) {
                        flag = false;
                    }
                }
                
                if (flag) {
                    int sumr1 = grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1];
                int sumr2 = grid[i][j-1] + grid[i][j] + grid[i][j+1];
                
                if (sumr1 != sumr2) continue;
                
                int sumr3 = grid[i+1][j-1] + grid[i+1][j] + grid[i+1][j+1];
                if (sumr1 != sumr3) continue;
                
                int sumc1 = grid[i-1][j-1] + grid[i][j-1] + grid[i+1][j-1];
                if (sumr1 != sumc1) continue;
                
                int sumc2 = grid[i-1][j] + grid[i][j] + grid[i+1][j];
                if (sumr1 != sumc2) continue;
                
                int sumc3 = grid[i-1][j+1] + grid[i][j+1] + grid[i+1][j+1];
                if (sumr1 != sumc3) continue;
                
                int sumd1 = grid[i-1][j-1] + grid[i][j] + grid[i+1][j+1];
                if (sumr1 != sumd1) continue;
                
                int sumd2 = grid[i-1][j+1] + grid[i][j] + grid[i+1][j-1];
                if (sumr1 != sumd2) continue;
                    
                    count++;
                }
                
                flag = true;
                arr = new int[16];
            }
        }
        
        return count;
    }
}
