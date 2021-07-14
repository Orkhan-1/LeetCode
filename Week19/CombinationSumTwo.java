import java.util.*;

public class CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet();
        bt (0, candidates, target, set, new ArrayList<>());
        return new ArrayList (set);
    }

    private void bt (int index, int[] candidates, int target, Set<List<Integer>> result, List<Integer> temp) {
        if (target == 0) {
            result.add (new ArrayList (temp));
            return;
        } else if (target<0) {
            return;
        }

        for (int i=index; i<candidates.length; i++) {
            temp.add(candidates[i]);
            index++;
            bt (index, candidates, target - candidates [i], result, temp);
            temp.remove (temp.size()-1);
        }
    }

}
