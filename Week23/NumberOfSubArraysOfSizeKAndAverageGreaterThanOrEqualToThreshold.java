/*
 *  Explanation:
 * -Move through the array until k and check whether the sum is equal or more than threshold.
 * If sum equal or more than threshold then increment result
 * -Move through the array from k to the end. At each step add i value from input array to the sum
 * and subtract i-k value from the sum; if sum equal or more than threshold then increment result
 *
 * */

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
