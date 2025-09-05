// 題目：Find First and Last Position of Element in Sorted Array
// 找出排序陣列中某個數字的起始和結束位置
public class lt_34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = findBound(nums, target, true);
        int right = findBound(nums, target, false);
        return new int[] { left, right };
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, bound = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                bound = mid;
                if (isFirst)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return bound;
    }
}
/*
 * 解題思路：
 * 1. 使用兩次二分搜尋，找出左邊界與右邊界。
 * 2. 目標不存在時回傳 [-1, -1]。
 */