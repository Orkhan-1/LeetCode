import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentMax = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentMax++;
                }

                max = Math.max(max, currentMax);
            }
        }

        return max;
    }

}
