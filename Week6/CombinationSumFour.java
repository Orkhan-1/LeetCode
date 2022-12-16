import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationSumFour {

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> cache = new HashMap<>();
        return bt(nums, target, cache);
    }

    private int bt(int[] nums, int target, Map<Integer, Integer> cache) {
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        int result = 0;
        for (int num : nums) {
            if (num > target) {
                break;
            } else if (num == target) {
                result += 1;
            } else {
                if (cache.containsKey(target - num)) {
                    result += cache.get(target - num);
                } else {
                    result += bt(nums, target - num, cache);
                }
            }
        }
        cache.put(target, result);
        return result;
    }

}
