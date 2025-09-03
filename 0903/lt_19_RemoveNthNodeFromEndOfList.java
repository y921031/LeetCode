// 題目：Remove Nth Node From End of List
// 給定鏈結串列 head，刪除倒數第 n 個節點並回傳新頭節點。

public class lt_19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 使用虛擬頭，處理刪除第一個節點的情況
        ListNode dummy = new ListNode(0);
        ListNode fast = dummy, slow = dummy;

        // 先讓 fast 前進 n+1 步，保持 slow 與 fast 間距 n
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 同步前進，直到 fast 到底
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow 指向待刪前一個節點
        slow.next = slow.next.next;
        return dummy.next;
    }
}

/*
 * 解題思路：
 * 1) 使用雙指針，fast 先走 n+1 步，之後 slow 和 fast 一起走，當 fast 到尾時 slow 正好指向待刪節點的前一個。
 * 2) 使用 dummy 節點，簡化刪除頭節點的情況。
 * 時間複雜度 O(L)，空間複雜度 O(1)。
 */