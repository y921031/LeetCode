// 題目：Remove Duplicates from Sorted Array
// 給定排序陣列 nums 就地移除重複，使每個元素只出現一次，回傳唯一元素個數 k。
public class lt_26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int slow = 1; // slow 指向下個應填唯一值的位置
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow; // 前 slow 個即為結果
    }
}
/*
 * 解題思路：
 * 1) 由於已排序，唯一元素必出現在值變化之處。
 * 2) 雙指針：fast 掃描，遇到新值就寫到 slow 位置並遞增。
 * 時間 O(n)，空間 O(1)。
 */
