package T0142;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 *
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int cycleSize = cycleSize(head);
        if (cycleSize == -1) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (true && fast != null) {
            cycleSize--;
            fast = fast.next;
            if (cycleSize <= 0) {
                slow = slow.next;
            }

            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }

    public int cycleSize(ListNode head) {
        ListNode oneSkip = head;
        ListNode twoSkip = head;
        while (oneSkip != null && twoSkip != null && twoSkip.next != null) {
            oneSkip = oneSkip.next;
            twoSkip = twoSkip.next.next;
            if (oneSkip == twoSkip) {
                int size = 1;
                oneSkip = oneSkip.next;
                while (oneSkip != twoSkip) {
                    size++;
                    oneSkip = oneSkip.next;
                }
                return size;
            }
        }

        return -1;
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