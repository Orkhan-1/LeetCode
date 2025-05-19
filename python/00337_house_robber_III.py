
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def dfs(node):
            if not node:
                return (0, 0)

            left = dfs(node.left)
            right = dfs(node.right)

            rob_this = node.val + left[1] + right[1]

            not_rob_this = max(left) + max(right)

            return (rob_this, not_rob_this)

        return max(dfs(root))

# Time Complexity: O(n); n is the number of nodes in the tree
# Space Complexity: O(h); h is the height of the tree (due to recursion stack)