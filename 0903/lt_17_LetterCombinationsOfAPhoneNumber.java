
// 題目：Letter Combinations of a Phone Number
// 給定只含 '2'~'9' 的字串 digits，回傳其可能代表的所有字母組合（順序不限）。
import java.util.*;

public class lt_17_LetterCombinationsOfAPhoneNumber {
    private static final String[] MAP = new String[] {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    // 回溯產生所有組合
    private void backtrack(String digits, int idx, StringBuilder path, List<String> res) {
        if (idx == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letters = MAP[digits.charAt(idx) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(digits, idx + 1, path, res);
            path.deleteCharAt(path.length() - 1); // 撤銷選擇
        }
    }
}
/*
 * 解題思路：
 * 1) 使用電話數字到字母的映射表（2→abc, 3→def, ...）。
 * 2) 透過回溯：對每個位數的所有字母嘗試組合，直到長度等於 digits。
 * 3) 每次加入/撤銷一個字母，最終收集所有路徑。
 * 時間複雜度 O(3^m * 4^n)，m 是對應 3 個字母的位數，n 是對應 4 個字母的位數；空間 O(L)。
 */