public class lt_11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, width * h);

            // 移動較矮的那一側，因為限制高度的是矮的那根
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}

/*
 * 解題思路：
 * 1. 雙指針法：從最左與最右兩條線開始，計算容積。
 * 2. 容積公式 = min(height[left], height[right]) * (right - left)。
 * 3. 為了得到更大面積，必須嘗試更高的邊，因此移動較矮的一側。
 * 4. 直到兩指針相遇為止，過程中更新最大值。
 * 時間複雜度：O(n)，只遍歷一次。
 */
