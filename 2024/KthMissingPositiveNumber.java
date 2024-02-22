// Time complexity - O (log N)
// Space complexity - O (1)
public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int missingBeforeMid = arr[mid] - mid - 1;

            if (missingBeforeMid < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left + k;
    }
}
