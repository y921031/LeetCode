// 題目：Swap Nodes in Pairs
// 每兩個相鄰節點交換，回傳新頭。

public class lt_24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = first;
        }
        return dummy.next;
    }
}

/*
 * 解題思路：
 * 1. 使用 dummy 節點方便處理頭節點。
 * 2. 每次取兩個相鄰節點交換指向。
 * 3. 迴圈直到剩下一個或零個節點。
 * 時間 O(n)，空間 O(1)。
 */
