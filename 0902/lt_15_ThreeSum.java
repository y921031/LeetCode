import java.util.*;

public class lt_15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // 避免重複

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // 跳過重複
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}

/*
 * 解題思路：
 * 1. 先排序，方便用雙指針找數字。
 * 2. 固定一個數 nums[i]，在右邊區間用雙指針找另外兩個數。
 * 3. 若總和 = 0，則記錄下來，並跳過重複值。
 * 4. 若總和 < 0，代表需要更大，左指針右移；若總和 > 0，右指針左移。
 * 5. 遍歷完成得到所有不重複三元組。
 * 時間複雜度：O(n^2)，排序 O(n log n) + 兩層迴圈。
 */
