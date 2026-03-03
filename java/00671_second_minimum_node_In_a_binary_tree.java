/*

🧩 Problem:
Given a special binary tree where every node's value is >= root value,
and every node has either 0 or 2 children.
Find the second minimum value among all nodes.
If it doesn't exist — return -1.

🌳 Example Tree:
           2
         /   \
        2     5
             / \
            5   7

🏷️ Values = [2, 2, 5, 5, 7]
🎯 Second Minimum = 5

🔍 Intuition:
- The smallest value is always the root's value.
- We traverse the tree:
  - If node.val > root.val ⇒ potential candidate for 2nd minimum.
  - Track the smallest such candidate.
- If we never find a value > root.val, return -1.

*/

class Solution {

    private int result = -1;

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return result;
    }

    private void dfs(TreeNode node, int minValue) {
        if (node == null) return;

        if (node.val > minValue) {
            if (result == -1 || node.val < result) {
                result = node.val;
            }
            return;
        }

        dfs(node.left, minValue);
        dfs(node.right, minValue);
    }
}
