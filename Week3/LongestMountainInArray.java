public class LongestMountainInArray {
    public int longestMountain(int[] A) {
        int n = A.length;
        if (n < 3) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int max = 0;

        while (start < n - 2) {
            while (start < n - 1 && A[start] >= A[start + 1]) {
                start++;
            }
            end = start + 1;

            while (end < n - 1 && A[end] < A[end + 1]) {
                end++;
            }

            while (end < n - 1 && A[end] > A[end + 1]) {
                end++;
                max = Math.max(max, end - start + 1);
            }
            start = end;
        }
        return max;
    }
}
