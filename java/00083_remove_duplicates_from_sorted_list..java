//       Java
// Time complexity - O (N)
// Space complexity - O (1)

// example: 1 -> 1 -> 2 -> 2 -> 3
// result:  1 -> 2 -> 3

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;

        while (pointer != null && pointer.next != null) {
            if (pointer.val == pointer.next.val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }

        }
        return head;
    }
}