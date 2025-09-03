
// 題目：Substring with Concatenation of All Words
// 給定字串 s 與 words（所有字長一致），找出所有起始索引，使得從該處開始的子字串
// 正好是 words 中所有單字不重複排列的連接（每字使用次數等於在 words 中出現次數）。
import java.util.*;

class lt_30_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return ans;

        int wordLen = words[0].length();
        int wordCnt = words.length;
        int windowLen = wordLen * wordCnt;
        if (s.length() < windowLen)
            return ans;

        // 統計 words 頻率
        Map<String, Integer> need = new HashMap<>();
        for (String w : words)
            need.put(w, need.getOrDefault(w, 0) + 1);

        // 因為單字等長，對齊 wordLen 的每個偏移分別滑動
        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset, right = offset, matched = 0;
            Map<String, Integer> window = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String w = s.substring(right, right + wordLen);
                right += wordLen;
                if (need.containsKey(w)) {
                    window.put(w, window.getOrDefault(w, 0) + 1);
                    if (window.get(w).equals(need.get(w)))
                        matched++; // 這個詞已滿足
                    // 若某詞超標，收縮左側直到不超標
                    while (window.get(w) > need.get(w)) {
                        String leftWord = s.substring(left, left + wordLen);
                        left += wordLen;
                        window.put(leftWord, window.get(leftWord) - 1);
                        if (window.get(leftWord) + 1 == need.get(leftWord))
                            matched--; // 可能破壞滿足
                    }
                    // 全部詞都達成指定次數
                    if (matched == need.size()) {
                        // 檢查窗口長度是否恰好
                        if (right - left == windowLen)
                            ans.add(left);
                        // 繼續滑動一次（移出最左一詞）
                        String leftWord = s.substring(left, left + wordLen);
                        left += wordLen;
                        window.put(leftWord, window.get(leftWord) - 1);
                        if (window.get(leftWord) + 1 == need.get(leftWord))
                            matched--;
                    }
                } else {
                    // 不在詞表：清空窗口，從下一個位置開始
                    window.clear();
                    matched = 0;
                    left = right;
                }
            }
        }
        return ans;
    }
}
/*
 * 解題思路：
 * 1) 所有單字長度相同 => 以 wordLen 為步長的多起點滑動視窗。
 * 2) 右指針每次擴張一個單字；若該字在詞表，放入 window 並檢查是否超標，超標就從左側移除至不超標。
 * 3) 當所有詞頻都恰好滿足（matched == need.size()）且窗口長度等於 wordCnt*wordLen，即記錄起點。
 * 4) 遇到非詞表單字則重置窗口。
 * 時間 O(L * wordLen) ≈ O(L)，L 為 s 長度，實作常數與 words 大小相關；空間 O(U)，U 為不同詞數。
 */