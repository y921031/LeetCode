public class lt_04_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            merged[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m)
            merged[k++] = nums1[i++];
        while (j < n)
            merged[k++] = nums2[j++];

        int total = m + n;
        if (total % 2 == 1)
            return merged[total / 2];
        return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
    }
}
