public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode first = head;

        while (k > 1) {
            first = first.next;
            k--;
        }

        ListNode second = head;

        ListNode temp = first;

        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        int tempValue = first.val;
        first.val = second.val;
        second.val = tempValue;
        return head;
    }
}
