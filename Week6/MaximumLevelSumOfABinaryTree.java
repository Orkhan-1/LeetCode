import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {

    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
