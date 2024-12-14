//       Java
// Time complexity - O (N)
// Space complexity - O (1)

// example: 1 -> 2 -> 3 -> 4 -> 5; n = 2
// result:  1 -> 2 -> 3 -> 5; n = 2

//  example: pointer (0) -> 1 -> 2 -> 3 -> 5; n = 2

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode fast = dummy;
        ListNode slow = dummy;
        dummy.next = head;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}