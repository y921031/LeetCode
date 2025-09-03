// 題目：Find the Index of the First Occurrence in a String (strStr)
// 回傳 needle 在 haystack 中第一次出現的索引，若不存在回傳 -1。
public class lt_28_FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        // KMP：先構建部分匹配表（lps）
        int[] lps = buildLps(needle);
        int i = 0, j = 0; // i 掃 haystack, j 掃 needle
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length())
                    return i - j; // 完全匹配
            } else {
                if (j > 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return -1;
    }

    private int[] buildLps(String p) {
        int n = p.length();
        int[] lps = new int[n];
        int len = 0; // 目前最長前後綴長度
        for (int i = 1; i < n;) {
            if (p.charAt(i) == p.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len > 0)
                    len = lps[len - 1];
                else
                    lps[i++] = 0;
            }
        }
        return lps;
    }
}
/*
 * 解題思路：
 * 1) KMP 演算法：用 lps 陣列記錄每個位置對應的最長相等前後綴長度。
 * 2) 匹配失敗時，needle 指標 j 依 lps 回退，避免重複比對。
 * 時間 O(n+m)，空間 O(m)。
 */