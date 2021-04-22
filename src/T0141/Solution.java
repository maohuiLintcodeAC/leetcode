package T0141;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode oneSkip = head;
        ListNode twoSkip = head;
        while (oneSkip != null && twoSkip != null && twoSkip.next != null) {
            oneSkip = oneSkip.next;
            twoSkip = twoSkip.next.next;
            if (oneSkip == twoSkip) {
                return true;
            }
        }

        return false;
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