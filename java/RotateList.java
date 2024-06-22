public class RotateList {

    // Time complexity - O (N)
    // Space complexity - O (1)
    public ListNode rotateRight(ListNode head, int k) {

        // 1->2->3>4->5 k=2

        // size size-k

        // 4->5->1->2->3->null

        if (head == null) {
            return null;
        }

        int size = 1;

        ListNode sizeNode = head;

        while (sizeNode.next != null) {
            size++;
            sizeNode = sizeNode.next;
        }

        ListNode newNode = head;

        for (int i = 1; i < size - k % size; i++) {
            newNode = newNode.next;
        }
        sizeNode.next = head;
        head = newNode.next;
        newNode.next = null;
        return head;
    }
}
