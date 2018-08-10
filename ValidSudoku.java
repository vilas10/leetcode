/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/


public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return true;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        if(rows != 9 || cols != 9) {
            return false;
        }
        
        HashSet hsRow = new HashSet();
        HashSet hsCol = new HashSet();
        HashSet hsSqr = new HashSet();
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(board[i][j] != '.') {
                    if(board[i][j] < 49 || board[i][j] > 57) {
                        return false;
                    }
                    
                    if(hsRow.contains(board[i][j] + "")) {
                        return false;
                    } else {
                        hsRow.add(board[i][j] + "");
                    }
                }
                
                if(board[j][i] != '.') {
                    if(board[j][i] < 49 || board[j][i] > 57) {
                        return false;
                    }
                    
                    if(hsCol.contains(board[j][i] + "")) {
                        return false;
                    } else {
                        hsCol.add(board[j][i] + "");
                    }
                }
            }
            
            hsRow.clear();
            hsCol.clear();
        }
        
        for(int k=0; k<rows; k+=3) {
            for(int l=0; l<cols; l+=3) {
                for(int i=k; i<k+3; i++) {
                    for(int j=l; j<l+3; j++) {
                        if(board[i][j] != '.') {
                
                            if(hsSqr.contains(board[i][j] + "")) {
                                return false;
                            } else {
                                hsSqr.add(board[i][j] + "");
                            }
                        }
                    }
                }
                
                hsSqr.clear();
            }
        }
        
        return true;
    }
}
