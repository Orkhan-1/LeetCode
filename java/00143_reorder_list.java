public class ReorderList {

    // Time complexity - O (N)
    // Space complexity - O (1)
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow;
        ListNode cur = slow.next;

        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = mid.next;
            mid.next = next;
        }

        ListNode l1 = head;
        ListNode l2 = mid.next;

        while (l1 != mid) {
            mid.next = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
            l2 = mid.next;
        }
    }
}
