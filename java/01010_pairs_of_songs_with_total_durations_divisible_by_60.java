import java.util.HashMap;
import java.util.Map;

// Time complexity - O (N)
// Space complexity - O (1)
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> remainderCounts = new HashMap<>();
        int result = 0;

        for (int t : time) {
            int remainder = t % 60;
            int complement = (60 - remainder) % 60;
            result += remainderCounts.getOrDefault(complement, 0);
            remainderCounts.put(remainder, remainderCounts.getOrDefault(remainder, 0) + 1);
        }

        return result;
    }
}
