public class SwappingNodesInALinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode firstNode = head;
        k--;
        while (k > 0) {
            firstNode = firstNode.next;
            k--;
        }

        ListNode secondNode = head;

        ListNode tempNode = firstNode;

        while (tempNode.next != null) {
            tempNode = tempNode.next;
            secondNode = secondNode.next;
        }

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
        return head;
    }
}
