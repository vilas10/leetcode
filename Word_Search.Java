/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word.length() == 0) {
            return true;
        }
        char[] w = word.toCharArray();
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(exist(board, w, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    boolean exist(char[][] board, char[] word, int i, int j, int pos) {
        if(pos == word.length) {
            return true;
        }
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*') {
            return false;
        }
        
        if(board[i][j] != word[pos]) {
            return false;
        }
        
        board[i][j] = '*';
        
        boolean ret = exist(board, word, i-1, j, pos+1) || exist(board, word, i, j-1, pos+1) 
                        || exist(board, word, i+1, j, pos+1) || exist(board, word, i, j+1, pos+1);
        
        board[i][j] = word[pos];
        
        return ret;
    }
}
