import java.util.Random;

public class RandomPickWithWeight {

    private int[] prefixSum;
    private Random random;

    public RandomPickWithWeight(int[] w) {
        int n = w.length;
        prefixSum = new int[n];
        random = new Random();

        prefixSum[0] = w[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int target = random.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        int left = 0, right = prefixSum.length - 1;

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
