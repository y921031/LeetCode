// 題目：Next Permutation（下一個排列）
// 給定一個整數陣列 nums，找出這個陣列的下一個「字典順序」排列。
// 如果沒有更大的排列（例如 [3,2,1]），則回傳最小的排列（即升序排列）。
public class lt_31_NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // 1. 從後往前找第一個「升序」的位置 i
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. 若找到 i，從後往前找第一個比 nums[i] 大的數字，並交換
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 3. 將 i+1 之後的數字反轉（由大到小變為由小到大）
        reverse(nums, i + 1, nums.length - 1);
    }

    // 交換兩個索引的數值
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 反轉區間 [start, end] 的元素
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}

/*
 * 解題思路：
 * 1. 題目要求找到「下一個字典順序排列」。
 * 2. 從右邊找第一個「下降」的位置 i（即 nums[i] < nums[i+1]）。
 * 3. 再從右邊找第一個比 nums[i] 大的數字 j，交換 nums[i] 和 nums[j]。
 * 4. 最後將 i 之後的部分「反轉」，使其變成最小排列（升序）。
 * 5. 若整個陣列都是下降的（如 [3,2,1]），直接反轉成升序排列。
 * 時間複雜度：O(n)
 * 空間複雜度：O(1)
 */