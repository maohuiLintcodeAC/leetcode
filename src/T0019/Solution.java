package T0019;


public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode firstPoint = head;
        ListNode secondPoint = null;
        ListNode prePoint = null;
        int index = 0; //1,2,3,4,5
        while (firstPoint != null) {  //1
            firstPoint = firstPoint.next;  //2
            index++; // 1

            if (secondPoint != null) {
                secondPoint = secondPoint.next;
            }
            if (prePoint != null) {
                prePoint = prePoint.next;
            }
            if (index == n) {
                secondPoint = head;  //1
            }
            if (index == n+1) {
                prePoint = head;
            }
        }

        if (n == index) {
            return head.next;
        }
        if (prePoint == null) {
            prePoint = head;
        }
        prePoint.next = secondPoint.next;
        secondPoint.next = null;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.val = 1;
//        node1.next = node2;
        node2.val = 2;
//        node2.next = node3;
//        node3.val = 3;
        ListNode result = solution.removeNthFromEnd(node1, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}