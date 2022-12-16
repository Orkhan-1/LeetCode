import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] input = {2, 3, 6, 7};
        int targe = 7;
        new CombinationSum().combinationSum(input, targe);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        bt(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void bt(int start, int[] candidates, int target, List<Integer> tmp, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            bt(i, candidates, target - candidates[i], tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }
}
