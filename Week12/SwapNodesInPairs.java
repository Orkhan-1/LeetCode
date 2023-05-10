public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode newNode = helper;
        while (newNode.next != null && newNode.next.next != null) {
            ListNode first = newNode.next;
            ListNode second = newNode.next.next;
            newNode.next = second;
            first.next = second.next;
            second.next = first;
            newNode = first;
        }
        return helper.next;
    }
}
