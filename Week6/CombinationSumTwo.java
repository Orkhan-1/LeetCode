import java.util.*;

public class CombinationSumTwo {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<>();
        bt(0, candidates, target, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    private void bt(int start, int[] candidates, int target, List<Integer> temp, Set<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            bt(start++, candidates, target - candidates[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
