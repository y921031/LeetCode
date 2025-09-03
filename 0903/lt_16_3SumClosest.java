// 題目：3Sum Closest
// 給定一個整數陣列 nums 和一個目標值 target，找出其中三個整數，
// 使得它們的和最接近 target，並回傳這三個數字的和。
// 題目保證僅存在一個唯一解。

import java.util.Arrays;

public class lt_16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // 先排序，方便用雙指針法處理
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        // 固定一個數，另外兩個數用雙指針尋找
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 若比目前更接近目標，更新答案
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                if (sum < target) {
                    left++; // 和太小，往右移
                } else if (sum > target) {
                    right--; // 和太大，往左移
                } else {
                    return sum; // 剛好等於 target，直接回傳
                }
            }
        }
        return closestSum;
    }
}

/*
 * 解題思路：
 * 1. 先將陣列排序，方便雙指針遍歷。
 * 2. 固定一個數 nums[i]，剩下兩個數用「左右指針」逼近 target。
 * 3. 每次計算當前三數和，若比之前更接近 target，則更新答案。
 * 4. 若 sum < target，左指針右移；若 sum > target，右指針左移。
 * 5. 若 sum == target，表示剛好符合，直接回傳。
 * 時間複雜度：O(n^2)，排序 O(n log n)，再雙層迴圈 O(n^2)。
 */