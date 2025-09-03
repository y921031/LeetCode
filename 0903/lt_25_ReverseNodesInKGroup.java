// 題目：Reverse Nodes in k-Group
// 每 k 個一組反轉鏈結串列；不足 k 保持原樣。

public class lt_25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null)
                break;
            ListNode groupNext = kth.next;

            // 反轉 k 個節點
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}

/*
 * 解題思路：
 * 1. 每次檢查是否有 k 個節點，若不足則結束。
 * 2. 若有，則反轉該區間，連接到結果。
 * 3. 更新指標繼續處理下一組。
 * 時間 O(n)，空間 O(1)。
 */