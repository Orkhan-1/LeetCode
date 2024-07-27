// Time complexity - O (N)
// Space complexity - O (N)
public class AddTwoNumbersTwo {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode head = new ListNode(0);
        ListNode result = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int valOne = getNumber(l1);
            int valTwo = getNumber(l2);
            int sum = valOne + valTwo + carry;
            result.next = new ListNode(sum % 10);
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            result = result.next;
        }

        return reverse(head.next);
    }

    private int getNumber(ListNode node) {
        if (node == null) {
            return 0;
        }
        return node.val;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
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
