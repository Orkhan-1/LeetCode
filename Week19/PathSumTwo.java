import java.util.ArrayList;
import java.util.List;

public class PathSumTwo {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result= new ArrayList<>();
        if(root==null) {
            return result;
        }
        dfs(result, new ArrayList<Integer>(), sum, root);
        return result;
    }
    public void dfs(List<List<Integer>> result,  ArrayList<Integer> temp, int sum,TreeNode root){
        if(root==null) {
            return;
        }
        temp.add(root.val);
        if(sum==root.val && root.left==null && root.right==null){
            result.add(temp);
            return;
        }
        dfs(result, new ArrayList<Integer>(temp), sum-root.val, root.left);
        dfs(result, new ArrayList<Integer>(temp), sum-root.val, root.right);
    }
}
