// 題目：Search Insert Position
// 搜尋插入位置
// 在有序陣列中找到目標插入的位置
public class lt_35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
/*
 * 解題思路：
 * 1. 使用二分搜尋找出第一個大於等於 target 的位置。
 * 2. O(log n) 時間複雜度。
 */
