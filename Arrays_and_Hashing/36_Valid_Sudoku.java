/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
Example 1:


Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Initalize sets with null values
        HashSet<Character> rowSet = null;
        HashSet<Character> colSet = null;

        // Check rows and columsns with two for loops
        for (int i = 0; i < 9; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char r = board[i][j];
                char c = board[j][i];

                if (r != '.') {
                    if (rowSet.contains(r)) return false;
                    rowSet.add(r);
                }
                if (c != '.') {
                    if (colSet.contains(c)) return false;
                    colSet.add(c);
                }

            }
        }

        // Block Implementation 3x3 -> add to func
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkBoard(i, j, board)) return false;
            }
        }
        return true;
    }
    // Check Block Function
    public boolean checkBoard(int idI, int idJ, char[][] board) {
        // setting ranges for each of the check Board(3x3)
        int rows = idI + 3;
        int cols = idJ + 3;
        HashSet<Character> boardSet = new HashSet<>();

        for (int i = idI; i < rows; i++) {
            for (int j = idJ; j < cols; j++) {
                if (board[i][j] != '.') {
                    if (boardSet.contains(board[i][j])) return false;
                    boardSet.add(board[i][j]);
                }
            }
        }
        return true;
    }
}