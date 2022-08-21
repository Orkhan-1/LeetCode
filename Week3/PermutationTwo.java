import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationTwo {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> current = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        bt(result, current, visited, nums);
        return new ArrayList<>(result);
    }

    private void bt(Set<List<Integer>> res, List<Integer> current, boolean[] visited, int[] nums) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            current.add(nums[i]);
            bt(res, current, visited, nums);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
