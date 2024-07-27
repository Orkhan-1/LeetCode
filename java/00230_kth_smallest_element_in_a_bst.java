import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABst {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedArray = inOrder(root, new ArrayList<>());
        return sortedArray.get(k - 1);
    }

    private List<Integer> inOrder(TreeNode root, List<Integer> array) {
        if (root == null) {
            return array;
        }

        inOrder(root.left, array);
        array.add(root.val);
        inOrder(root.right, array);
        return array;
    }
}
