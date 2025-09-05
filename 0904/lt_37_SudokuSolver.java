// 題目：Sudoku Solver
// 解出一個 9x9 的數獨盤面，填入合法數字
public class lt_37_SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j)
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
        return true;
    }

    private boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == ch || board[r][i] == ch ||
                    board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == ch)
                return false;
        }
        return true;
    }
}
/*
 * 解題思路：
 * 1. 使用回溯法填入數字。
 * 2. 每次嘗試 1~9，判斷是否合法，不合法就回溯。
 */