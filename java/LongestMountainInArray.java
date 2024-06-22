// Time complexity - O (N)
// Space complexity - O (1)
public class LongestMountainInArray {


    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int max = 0;

        while (start < n - 2) {
            while (start < n - 1 && arr[start] >= arr[start + 1]) {
                start++;
            }
            end = start;
            while (end < n - 1 && arr[end] < arr[end + 1]) {
                end++;
            }

            while (end < n - 1 && arr[end] > arr[end + 1]) {
                end++;
                max = Math.max(max, end - start + 1);
            }
            start = end;
        }
        return max;
    }
}
