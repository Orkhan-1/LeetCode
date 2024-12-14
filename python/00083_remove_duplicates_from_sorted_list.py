#       Python
# Time complexity - O (N)
# Space complexity - O (1)

# example: 1 -> 1 -> 2 -> 2 -> 3
# result:  1 -> 2 -> 3

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pointer = head

        while pointer and pointer.next:
            if pointer.val == pointer.next.val:
                # Skip the duplicate node
                pointer.next = pointer.next.next
            else:
                # Move to the next node
                pointer = pointer.next

        return head
