/**
 *
 * Problem:
 * Given a binary tree, collect all leaves, remove them, repeat until the tree is empty.
 *
 * Example:
 *       1️⃣
 *      /   \
 *    2️⃣     3️⃣
 *   /  \
 * 4️⃣   5️⃣
 *
 * Output: [[4,5,3],[2],[1]]
 *
 * Step-by-step 🍂:
 * Step 1 (leaves): 4️⃣,5️⃣,3️⃣ → remove
 *       1️⃣
 *      /
 *    2️⃣
 * Output: [4,5,3]
 *
 * Step 2 (new leaves): 2️⃣ → remove
 *       1️⃣
 * Output: [2]
 *
 * Step 3 (new leaves): 1️⃣ → remove
 * Output: [1]
 *
 * Approach 🧠:
 * - DFS from bottom to top.
 * - Compute "height" of each node:
 *     leaves → height 0
 *     parent → max(child heights) + 1
 * - Group nodes by their height.
 *
 * Height visualization 📏:
 *       2️⃣ (h=2)
 *      / \
 *    1️⃣   0️⃣
 *   / \
 * 0️⃣   0️⃣
 *
 * Result by height:
 * 0️⃣ → [4️⃣,5️⃣,3️⃣]
 * 1️⃣ → [2️⃣]
 * 2️⃣ → [1️⃣]
 */

import java.util.*;

class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private int dfs(TreeNode node, List<List<Integer>> res) {
        if (node == null) {
            return -1;
        }

        int leftHeight = dfs(node.left, res);
        int rightHeight = dfs(node.right, res);
        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        if (res.size() <= currHeight) {
            res.add(new ArrayList<>());
        }

        res.get(currHeight).add(node.val);
        return currHeight;
    }
}

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
