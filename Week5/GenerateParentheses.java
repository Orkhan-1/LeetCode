import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        findParentheses(result, "", n, 0, 0);
        return result;
    }

    /*
     * Base cases:
     * 1. ( cannot be more than n
     * 2. ) cannot be more than n
     * 3. ) cannot be more than ( e.g. (()))
     * */
    private void findParentheses(List<String> result, String temp, int n, int left, int right) {

        if (left > n || right > n || right > left) {
            return;
        }

        if (left == n && right == n) {
            result.add(temp);
            return;
        }

        findParentheses(result, temp + "(", n, left + 1, right);
        findParentheses(result, temp + ")", n, left, right + 1);
    }
}
