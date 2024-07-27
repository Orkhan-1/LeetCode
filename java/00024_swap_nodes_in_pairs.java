public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode newN = helper;

        while (newN.next != null && newN.next.next != null) {
            ListNode first = newN.next;
            ListNode second = newN.next.next;
            newN.next = second;
            first.next = second.next;
            second.next = first;
            newN = first;
        }

        return helper.next;
    }

    public class ListNode {
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
}