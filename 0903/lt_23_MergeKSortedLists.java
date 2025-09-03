// 題目：Merge k Sorted Lists
// 合併 k 個已排序鏈結串列，回傳合併後的頭節點。

import java.util.*;

public class lt_23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null)
                pq.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null)
                pq.offer(node.next);
        }
        return dummy.next;
    }
}

/*
 * 解題思路：
 * 1. 使用最小堆（優先佇列），將所有鏈表頭節點放入。
 * 2. 每次取最小節點，接到結果，若該節點有 next，放回堆。
 * 3. 重複直到堆空。
 * 時間 O(N log k)，N 總節點數。
 */
