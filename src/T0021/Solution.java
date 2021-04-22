package T0021;

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

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode dummyHead = new ListNode();
        ListNode currentPosition = dummyHead;
        while (true) {
            if (l1 == null) {
                currentPosition.next = l2;
                break;
            }
            if (l2 == null) {
                currentPosition.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                currentPosition.next = l1;
                l1 = l1.next;
            } else {
                currentPosition.next = l2;
                l2 = l2.next;
            }
            currentPosition = currentPosition.next;
        }

        return dummyHead.next;
    }
}