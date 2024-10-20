import java.util.HashMap;
import java.util.Map;

// Time complexity - O (n)
// Space complexity - O (n)
class SparseVector {
    private Map<Integer, Integer> nonZeroElements = new HashMap<>();

    public SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroElements.put(i, nums[i]);
            }
        }
    }

    public int dotProduct(SparseVector vec) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : nonZeroElements.entrySet()) {
            int index = entry.getKey();
            int value = entry.getValue();
            if (vec.nonZeroElements.containsKey(index)) {
                result += value * vec.nonZeroElements.get(index);
            }
        }
        return result;
    }
}
