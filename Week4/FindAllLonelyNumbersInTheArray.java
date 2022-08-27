import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllLonelyNumbersInTheArray {

    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Boolean> numbers = new HashMap();
        List<Integer> result = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            if (numbers.containsKey(nums[i])) {
                numbers.put(nums[i], true);
                flag = true;
            }
            if (numbers.containsKey(nums[i] + 1)) {
                numbers.put(nums[i] + 1, true);
                numbers.put(nums[i], true);
                flag = true;
            }
            if (numbers.containsKey(nums[i] - 1)) {
                numbers.put(nums[i] - 1, true);
                numbers.put(nums[i], true);
                flag = true;
            }
            if (!flag) {
                numbers.put(nums[i], false);
            }
        }

        for (Map.Entry<Integer, Boolean> number : numbers.entrySet()) {
            if (!number.getValue()) {
                result.add(number.getKey());
            }
        }
        return result;
    }
}
