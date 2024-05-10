import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> remainderCount = new HashMap<>();

        int count = 0;

        for (int t : time) {
            int remainder = t % 60;
            int complement = (60 - remainder) % 60;
            count += remainderCount.getOrDefault(complement, 0);
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
