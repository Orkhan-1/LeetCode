import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) {
            return result;
        }
        bt(1, k, n, new ArrayList<>());
        return result;
    }

    public void bt(int start, int k, int n, List<Integer> temp) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (k == 0 || n < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            bt(i + 1, k - 1, n - i, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
