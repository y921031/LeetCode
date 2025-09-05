// 題目：Search in Rotated Sorted Array
// 在旋轉過的有序陣列中搜尋目標值，要求 O(log n) 時間。
public class lt_33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
/*
 * 解題思路：
 * 1. 使用二分搜尋，根據旋轉的特性選擇搜尋區間。
 * 2. 判斷哪一邊是有序的，然後決定是否在該區間繼續搜尋。
 */