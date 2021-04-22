package T0061;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        ListNode slow = head;
        ListNode slowPre = head;
        ListNode fast = head;

        while (fast.next != null) {
            fast = fast.next;
        }
        fast.next = head;

        fast = head;
        int index = 0;
        while (fast.next != null) {
            index++;
            fast = fast.next;
            if (index >= k) {
                slowPre = slow;
                slow = slow.next;
                if (fast == head) {
                    break;
                }
            }
        }

        slowPre.next = null;
        return slow;
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