public class lt_14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }
}

/*
 * 解題思路：
 * 1. 先假設第一個字串是公共前綴。
 * 2. 從第二個字串開始，不斷縮短 prefix，直到符合當前字串的開頭。
 * 3. 若 prefix 變成空字串，則直接返回 ""。
 * 時間複雜度：O(n * m)，n 為字串數量，m 為最長字串長度。
 */
