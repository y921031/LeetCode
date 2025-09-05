// 題目：Combination Sum
// 給定一個不重複整數陣列 candidates 和目標值 target，
// 找出所有可以讓數字和等於 target 的組合。
// 每個數字可以使用多次，組合順序不同視為相同。

import java.util.*;

class lt_39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start,
            List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path)); // 找到組合，加入結果
            return;
        }
        if (target < 0)
            return; // 超過目標值，回溯

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            // i 不變，因為同一個數字可以重複使用
            backtrack(candidates, target - candidates[i], i, path, res);
            path.remove(path.size() - 1); // 回溯
        }
    }
}
/*
 * 解題思路：
 * 1. 使用回溯法 (Backtracking)，遍歷所有可能組合。
 * 2. 若總和超過 target，直接回溯；若剛好等於 target，加入答案。
 * 3. 由於每個數字可重複使用，遞迴呼叫時參數仍是 i。
 * 4. 最後輸出所有符合條件的組合。
 */