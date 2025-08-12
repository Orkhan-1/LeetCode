class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None

        from collections import deque
        queue = deque([root])

        while queue:
            size = len(queue)
            for i in range(size):
                current = queue.popleft()
                # Connect to the next node if it’s not the last in the level
                if i < size - 1:
                    current.next = queue[0]
                else:
                    current.next = None
                # Add children
                if current.left:
                    queue.append(current.left)
                if current.right:
                    queue.append(current.right)

        return root