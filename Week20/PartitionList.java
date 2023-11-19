public class PartitionList {

    // Time complexity - O (N)
    // Space complexity - O (1) - It points to the same ListNode in the memory
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lHead;
        ListNode l = new ListNode(0);
        ListNode gHead;
        ListNode g = new ListNode(0);
        lHead = l;
        gHead = g;

        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                g.next = head;
                g = g.next;
            }
            head = head.next;
        }
        g.next = null;
        l.next = gHead.next;
        return lHead.next;
    }
}
