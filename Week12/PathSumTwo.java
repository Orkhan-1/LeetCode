import java.util.ArrayList;
import java.util.List;

public class PathSumTwo {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        dfs(root, targetSum, 0, new ArrayList(), result);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, int sum, List<Integer> temp, List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        temp.add(root.val);
        sum += root.val;

        if (root.left == null && root.right == null && sum == targetSum) {
            result.add(new ArrayList(temp));
        }

        dfs(root.left, targetSum, sum, temp, result);
        dfs(root.right, targetSum, sum, temp, result);
        temp.remove(temp.size() - 1);
    }
}
