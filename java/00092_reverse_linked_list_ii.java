public class ReverseLinkedListTwo {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        int i = 1;
        while (i < left) {
            cur = cur.next;
            prev = prev.next;
            i++;
        }
        ListNode start = prev;
        ListNode end = cur;
        ListNode tmp = null;
        while (i <= right) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            i++;
        }
        start.next = prev;
        end.next = tmp;
        return dummy.next;
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
