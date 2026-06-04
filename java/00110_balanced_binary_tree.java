/*

Balanced Binary Tree

A binary tree is height-balanced if:
For every node,
| height(left) - height(right) | <= 1

Example:

        3
      /   \
     9     20
          /  \
        15    7

Heights:
9  -> 1
15 -> 1
7  -> 1
20 -> 2
3  -> 3

Difference at every node <= 1
✅ Balanced


Counter Example:

          1
         /
        2
       /
      3
     /
    4

Heights:
4 -> 1
3 -> 2
2 -> 3
1 -> 4

At node 2:
left = 2, right = 0
difference = 2

❌ Not Balanced


💡 Key Observation

Naive approach:

For every node:
    height(left)
    height(right)

This repeatedly recomputes heights.

Return:
    height if subtree is balanced
    -1 if subtree is NOT balanced

If any child returns -1:
    propagate -1 upward immediately.

*/


class SolutionOne {

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        if (left == -1) {
            return -1;
        }

        int right = height(node.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}