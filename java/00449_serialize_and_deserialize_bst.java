/**



 🎯 GOAL
 Serialize (BST → String) and Deserialize (String → same BST) 🌳

 ------------------------------------------------
 🧠 IDEA
 Use Preorder Traversal:
 - Preorder uniquely identifies BST.
 - During deserialization, rebuild using value bounds (min, max).

 ------------------------------------------------
 🌲 EXAMPLE
 8
 / \
 5   10
 / \    \
 1   7    12

 Preorder → 8,5,1,7,10,12

 Deserialize process:
 1️⃣ 8 fits (-∞,∞)
 2️⃣ 5 fits (-∞,8)
 3️⃣ 1 fits (-∞,5)
 4️⃣ 7 fits (5,8)
 5️⃣ 10 fits (8,∞)
 6️⃣ 12 fits (10,∞)

 Result ✅ same BST restored.

 ------------------------------------------------
 ⏱️ COMPLEXITY
 Time: O(n)
 Space: O(n)
 */

public class Solution {

    // Serialize BST → String (preorder)
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(",");
        }
        sb.append(node.val);
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    // Deserialize String → BST using bounds
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] vals = data.split(",");
        int[] i = new int[1];
        return build(vals, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

/*

Deserialize process:
1️⃣ 8 fits (-∞,∞)
2️⃣ 5 fits (-∞,8)
3️⃣ 1 fits (-∞,5)
4️⃣ 7 fits (5,8)
5️⃣ 10 fits (8,∞)
6️⃣ 12 fits (10,∞)

*/


    private TreeNode build(String[] vals, int[] i, int min, int max) {
        if (i[0] == vals.length) {
            return null;
        }
        int val = Integer.parseInt(vals[i[0]]);   // Preorder → 8,5,1,7,10,12
        if (val < min || val > max) {
            return null;
        }

        TreeNode node = new TreeNode(val);
        i[0]++;
        node.left = build(vals, i, min, val);
        node.right = build(vals, i, val, max);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}