//       Java
// Time complexity - O (N)
// Space complexity - O (1)

// example: 1 -> 2 -> 3 -> 4 -> 3 -> 5; value = 3
// result: 1 -> 2 -> 4 -> 5; value = 3

//example: pointer (0) -> 1 -> 2 -> 4 -> 5; value = 3

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pointer = new ListNode(0);
        pointer.next = head;
        ListNode result = pointer;
        while (pointer != null && pointer.next != null) {
            if (pointer.next.val == val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return result.next;
    }
}