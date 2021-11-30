/*
 *  Explanation:
 * -First to add numbers reverse l1 and l2 nodes
 * -Create new node called {head} where results will be added; not to lose head of result {head} create a new pointer {result}
 * -Create variable carry where carry from previous sum will be added
 * -Until l1!=null and l2!=null and carry!=0 calculate sum=l1.val+l2.val+carry
 * -Take modulo of sum and add it as new node to the result: sum%10
 * -Calculate carry: sum/10
 * -At the end reverse the {head}
 * */

public class AddTwoNumbersTwo {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode head = new ListNode(0);
        ListNode result = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = getNumber(l1);
            int l2Val = getNumber(l2);
            int sum = l1Val + l2Val + carry;
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
}
