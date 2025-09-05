// 題目：Combination Sum II
// 給定一個整數陣列 candidates（可能包含重複數字）和一個目標值 target，
// 找出所有可以讓數字和等於 target 的唯一組合。
// 每個數字最多只能使用一次，結果不能包含重複組合。

import java.util.*;

public class lt_40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先排序，方便去除重複組合
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start,
            List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0)
            return;

        for (int i = start; i < candidates.length; i++) {
            // 跳過同一層的重複數字，避免產生重複解
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            path.add(candidates[i]);
            // i+1，因為每個數字只能用一次
            backtrack(candidates, target - candidates[i], i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
/*
 * 解題思路：
 * 1. 與 Combination Sum 類似，也是回溯法 (Backtracking)。
 * 2. 不同點：每個數字最多只能用一次 → 遞迴呼叫時 index 要用 i+1。
 * 3. 為避免重複組合，先排序，並在同一層遞迴時跳過重複的數字。
 */