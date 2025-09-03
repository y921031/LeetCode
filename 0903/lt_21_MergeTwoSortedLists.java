// 題目：Merge Two Sorted Lists
// 合併兩個已排序鏈結串列，回傳合併後的頭節點。

public class lt_21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}

/*
 * 解題思路：
 * 1. 用 dummy 節點簡化流程。
 * 2. 比較兩鏈表頭部，較小者連到結果。
 * 3. 一方為空後，直接接上另一方。
 * 時間 O(m+n)，空間 O(1)。
 */