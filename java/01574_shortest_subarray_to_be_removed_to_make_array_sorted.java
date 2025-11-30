/*

Example 1:
arr = [1,2,3,10,4,2,3,5] = 3

prefix [1,2,3,10]
               i
suffix [2,3,5]
          j
Result = [1,2,3,3,5]

Shortest subarray to remove = 3

=========================================================================
=========================================================================

Example 2:
arr = [1,2,3]

Already non-decreasing → remove 0 elements
Answer = 0


Example 3:
arr = [5,4,3,2,1]

Completely decreasing → remove n−1 elements
Answer = 4

*/

public class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Step 1: find longest non-decreasing prefix
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        if (left == n - 1) {
            return 0; // already sorted
        }

        // Step 2: find longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Step 3: remove entire middle section initially
        int result = Math.min(n - left - 1, right);

        // Step 4: two-pointer merge prefix & suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
