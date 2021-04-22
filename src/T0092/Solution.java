package T0092;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 1;
        ListNode cur = head;
        ListNode pre = null;
        while (index < m) {
            index++;
            pre = cur;
            cur = cur.next;
        }

        ListNode node = reverseList(pre, cur, n - m);
        if (m == 1) {
            return node;
        }
        return head;
    }

    public ListNode reverseList(ListNode preHead, ListNode head, int count) {
        ListNode cur = head;
        ListNode pre = preHead;
        ListNode next = null;
        int index = 0;
        while (cur != null && index < count) {
            index++;
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (preHead != null) {
            preHead.next = cur;
        } else {
            preHead = cur;
        }
        head.next = next;
        return preHead;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}