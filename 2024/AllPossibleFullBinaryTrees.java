import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time complexity - O (2^N/2 => N)
// Space complexity - O (2^N/2 => N)
public class AllPossibleFullBinaryTrees {

    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {

        if (memo.containsKey(N)) {
            return memo.get(N);
        }

        List<TreeNode> result = new ArrayList<>();

        if (N % 2 == 0) {
            return result;
        }

        if (N == 1) {
            result.add(new TreeNode(0));
        } else {
            for (int i = 1; i < N; i += 2) {
                List<TreeNode> leftSubtrees = allPossibleFBT(i); // 1, 3, 5
                List<TreeNode> rightSubtrees = allPossibleFBT(N - 1 - i); // 5 , 3, 1

                for (TreeNode left : leftSubtrees) {
                    for (TreeNode right : rightSubtrees) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
        }

        memo.put(N, result);
        return result;
    }
}
