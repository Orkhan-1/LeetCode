import java.util.Random;

// Time complexity - O (N), O (log N)
// Space complexity - O (N)
public class RandomPickWithWeight {

    private int[] prefixSum;

    public RandomPickWithWeight(int[] w) {
        int n = w.length;
        prefixSum = new int[n];
        prefixSum[0] = w[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int target = new Random().nextInt(prefixSum[prefixSum.length - 1]) + 1;
        int left = 0;
        int right = prefixSum.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
