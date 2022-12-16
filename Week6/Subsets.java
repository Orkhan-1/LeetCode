import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubSets(result, nums, new ArrayList<>(), 0);
        return result;
    }

    private void findSubSets(List<List<Integer>> result, int[] nums, List<Integer> temElems, int start) {
        result.add(new ArrayList<>(temElems));
        for (int i = start; i < nums.length; i++) {
            temElems.add(nums[i]);
            findSubSets(result, nums, temElems, i + 1);
            temElems.remove(temElems.size() - 1);
        }
    }

}
