public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int result = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum / k >= threshold) {
            result++;
        }

        for (int i = k; i < arr.length; i++) {
            sum -= arr[i - k];
            sum += arr[i];
            if (sum / k >= threshold) {
                result++;
            }
        }
        return result;
    }
}
