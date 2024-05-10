import java.util.ArrayList;
import java.util.List;

public class FindTheMinimumNumberOFibonacciNumbersWhoseSumIsK {

    // Time complexity - O (log k)
    // Space complexity - O (log k)
    public int findMinFibonacciNumbers(int k) {
        int prev = 1;
        int current = 1;
        List<Integer> list = new ArrayList<>();
        list.add(prev);

        while (current <= k) {
            list.add(current);
            int temp = current;
            current += prev;
            prev = temp;
        }

        int result = 0;

        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) <= k) {
                k -= list.get(i);
                result++;
            }
        }
        return result;
    }
}
