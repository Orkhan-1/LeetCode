import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int totalSum = 0;

        Map <Integer, Integer> map = new HashMap ();
        map.put (0,1);
        for (int i=0; i<nums.length; i++) {
            totalSum+=nums[i];
            if (map.containsKey (totalSum-k)) {
                count += map.get (totalSum-k);
            }
            map.put (totalSum, map.getOrDefault(totalSum, 0)+1);
        }
        return count;
    }
}
