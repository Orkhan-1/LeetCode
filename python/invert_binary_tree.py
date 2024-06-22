#     Python
# Time complexity - O (N)
# Space complexity - O (H) - depth of recursion stack
# Worst (unbalanced) O(n) - , Best (balanced) - O(log(n))

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root is None:
            return None

        root.left, root.right = root.right, root.left

        self.invertTree(root.left)
        self.invertTree(root.right)

        return root
