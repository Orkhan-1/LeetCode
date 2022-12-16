import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        if (k <= 0 || n <= 0) {
            return result;
        }
        bt(1, k, n, new ArrayList<>(), result);
        return result;
    }

    public void bt(int start, int k, int n, List<Integer> temp, List<List<Integer>> result) {

        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (k == 0 || n < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            temp.add(i);
            bt(i + 1, k - 1, n - i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

}
