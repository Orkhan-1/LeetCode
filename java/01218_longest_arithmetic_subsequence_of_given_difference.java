import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {

    public int longestSubsequence(int[] arr, int difference) {

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentMax = 1;
            int num = arr[i] - difference;

            if (map.containsKey(num)) {
                currentMax = map.get(num) + 1;
            }
            map.put(arr[i], currentMax);
            max = Math.max(currentMax, max);
        }

        return max;
    }
}
