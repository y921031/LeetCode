// 題目：Remove Element
// 陣列 nums 中就地移除所有等於 val 的元素，回傳剩餘元素個數 k（前 k 個元素為答案）。
public class lt_27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
/*
 * 解題思路：
 * 1) 雙指針：fast 掃描原陣列，遇到非 val 值就寫到 slow，slow 前進。
 * 2) 結束後前 slow 個位置即為移除 val 後的結果。
 * 時間 O(n)，空間 O(1)。
 */
