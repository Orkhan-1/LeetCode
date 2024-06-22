import java.util.*;

// Time complexity - O (2^N * N)
// Space complexity - O (2^N * K)
public class SubsetsTwo {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        bt(result, nums, 0, new ArrayList<>());
        return new ArrayList(result);
    }

    private void bt(Set<List<Integer>> result, int[] nums, int start, List<Integer> tempResult) {
        if (!result.contains(tempResult)) {
            result.add(new ArrayList(tempResult));
        }

        for (int i = start; i < nums.length; i++) {
            tempResult.add(nums[i]);
            bt(result, nums, i + 1, tempResult);
            tempResult.remove(tempResult.size() - 1);
        }
    }
}
