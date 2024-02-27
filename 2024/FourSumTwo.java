import java.util.HashMap;
import java.util.Map;

// Time complexity - O (N^2)
// Space complexity - O (N^2)
public class FourSumTwo {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sumCD = num3 + num4;
                count += map.getOrDefault(-sumCD, 0);
            }
        }

        return count;
    }
}
