
// 題目：4Sum
// 給定整數陣列 nums 與 target，回傳所有不重複的四元組 [a,b,c,d] 使 a+b+c+d == target（順序不限）。
import java.util.*;

public class lt_18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // 去重
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue; // 去重
                int l = j + 1, r = n - 1;
                while (l < r) {
                    long sum = 0L + nums[i] + nums[j] + nums[l] + nums[r]; // 用 long 防溢位
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1])
                            l++; // 去重
                        while (l < r && nums[r] == nums[r + 1])
                            r--; // 去重
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
/*
 * 解題思路：
 * 1) 先排序以便使用雙指針和去重。
 * 2) 外層兩層迴圈固定 i, j；內層用 l, r 雙指針找剩下兩數。
 * 3) 遇到相等結果加入答案，並移動指針同時跳過重複。
 * 時間複雜度 O(n^3)，空間 O(1) 另加輸出。
 */