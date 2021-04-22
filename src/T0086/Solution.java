package T0086;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode minCur = null;
        ListNode maxCur = null;
        ListNode maxHead = null;
        ListNode minHead = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            if (head.val < x) {
                if (minCur == null) {
                    minCur = head;
                    minHead = head;
                } else {
                    minCur.next = head;
                    minCur = head;
                }
            } else {
                if (maxCur == null) {
                    maxCur = head;
                    maxHead = head;
                } else {
                    maxCur.next = head;
                    maxCur = head;
                }
            }
            head.next = null;
            head = next;
        }

        if (minCur != null) {
            minCur.next = maxHead;
        } else {
            minHead = maxHead;
        }
        return minHead;
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
