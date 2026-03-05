/*
LeetCode 655: Print Binary Tree

🧠 Idea:
We print the tree level by level in a 2D matrix,
where each node is centered between its left and right subtree.

🌳 Example:
Input:
      1
     / \
    2   3
     \
      4

Height = 3 → rows = 3, cols = 2^3 - 1 = 7

Result matrix:
[
  ["", "", "", "1", "", "", ""],
  ["", "2", "", "", "", "3", ""],
  ["", "", "4", "", "", "", ""]
]
*/

class Solution {

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int rows = height;
        int cols = (int) Math.pow(2, height) - 1;

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            result.add(row);
        }

        fill(root, result, 0, 0, cols - 1);
        return result;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private void fill(TreeNode node, List<List<String>> result, int row, int left, int right) {
        if (node == null) {
            return;
        }
        int mid = (left + right) / 2;
        result.get(row).set(mid, String.valueOf(node.val));
        fill(node.left, result, row + 1, left, mid - 1);
        fill(node.right, result, row + 1, mid + 1, right);
    }
}