import java.util.Arrays;

// Time complexity - O (N*K)
// Space complexity - O (N)
public class PartitionArrayForMaximumSumTopDown {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return maxSum(arr, k, 0, memo);
    }

    private int maxSum(int[] arr, int k, int index, int[] memo) {
        if (index == arr.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int maxSum = 0;
        int maxElement = 0;

        for (int i = index; i < Math.min(index + k, arr.length); i++) {
            maxElement = Math.max(maxElement, arr[i]);
            int windowSum = maxElement * (i - index + 1); // 1, 15, 7, 9
            maxSum = Math.max(maxSum, windowSum + maxSum(arr, k, i + 1, memo));
        }

        memo[index] = maxSum;
        return maxSum;
    }
}
