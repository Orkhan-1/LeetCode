# Python
# Time complexity - O (N)
# Space complexity - O (1)
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head or not head.next:
            return True

        s = head
        f = head
        while f and f.next:
            s = s.next
            f = f.next.next

        prev = None
        current = s
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node

        f = head
        s = prev
        while s:
            if f.val != s.val:
                return False
            f = f.next
            s = s.next

        return True
