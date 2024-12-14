#       Python
# Time complexity - O (N)
# Space complexity - O (1)

# example: 1 -> 2 -> 3 -> 4 -> 3 -> 5; value = 3
# result: 1 -> 2 -> 4 -> 5; value = 3

# example: pointer (0) -> 1 -> 2 -> 4 -> 5; value = 3

class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        pointer = ListNode(0)
        pointer.next = head
        result = pointer

        while pointer and pointer.next:
            if pointer.next.val == val:
                pointer.next = pointer.next.next
            else:
                pointer = pointer.next

        return result.next

