
// 題目：Generate Parentheses
// 給定 n 對括號，產生所有格式正確的括號組合。
import java.util.*;

public class lt_22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    // open：已放 '(' 數量；close：已放 ')' 數量
    private void backtrack(int n, int open, int close, StringBuilder path, List<String> res) {
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }
        if (open < n) { // 還能放 '('
            path.append('(');
            backtrack(n, open + 1, close, path, res);
            path.deleteCharAt(path.length() - 1);
        }
        if (close < open) { // ')' 數量不可超過 '('
            path.append(')');
            backtrack(n, open, close + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
/*
 * 解題思路：
 * 1) 回溯生成：任何時刻，右括號數量不可超過左括號；左括號不可超過 n。
 * 2) 當長度到 2n 時收集結果。
 * 時間 O(Catalan_n)，空間 O(n) 遞迴深度。
 */
