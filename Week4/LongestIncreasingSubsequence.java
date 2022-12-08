import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        List<Integer> result = new LinkedList<>();
        result.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > result.get(result.size() - 1)) {
                result.add(num);
            } else {
                int j = 0;
                while (num > result.get(j)) {
                    j += 1;
                }
                result.set(j, num);
            }
        }
        return result.size();
    }
}
