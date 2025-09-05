
// 題目：Valid Sudoku
// 判斷 9x9 的數獨盤面是否合法（不重複）
// 只需檢查目前填寫的數字，不要求解
import java.util.Set;
import java.util.HashSet;

public class lt_36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j) {
                char num = board[i][j];
                if (num == '.')
                    continue;
                if (!seen.add(num + " in row " + i) ||
                        !seen.add(num + " in col " + j) ||
                        !seen.add(num + " in box " + i / 3 + "-" + j / 3))
                    return false;
            }
        return true;
    }
}
/*
 * 解題思路：
 * 1. 使用 Set 檢查每個 row、column、box 是否有重複數字。
 * 2. 注意 box 的座標是 (i/3, j/3)。
 */
