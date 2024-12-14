#       Python
# Time complexity - O (N)
# Space complexity - O (1)

# example: 1 -> 2 -> 3 -> 4 -> 5; n = 2
# result:  1 -> 2 -> 3 -> 5; n = 2

# example: pointer (0) -> 1 -> 2 -> 3 -> 5; n = 2

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        pointer = ListNode(0)
        pointer.next = head
        fast = pointer
        slow = pointer

        # Move fast pointer n+1 steps ahead
        for _ in range(n + 1):
            fast = fast.next

        # Move both pointers until fast reaches the end
        while fast: # size - n
            fast = fast.next
            slow = slow.next

        # Remove the nth node from the end
        slow.next = slow.next.next

        return pointer.next
