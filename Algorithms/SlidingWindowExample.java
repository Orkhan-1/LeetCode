/*
 * Given an array of integers calculate the maximum sum of k consecutive elements in the array
 * */

public class SlidingWindowExample {

    public static int maxSumOfKConsecutiveElements(int[] arr, int k) {
        int n = arr.length;

        if (n < k) {
            return -1;
        }

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int currentSum = maxSum;

        for (int i = k; i < n; i++) {
            currentSum = currentSum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

}
