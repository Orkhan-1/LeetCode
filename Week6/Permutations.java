import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findDistinctValues(result, new ArrayList<>(), nums);
        return result;
    }

    private void findDistinctValues(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!temp.contains(nums[i])) {
                    temp.add(nums[i]);
                    findDistinctValues(result, temp, nums);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

}
