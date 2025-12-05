/*

Example:
Input:
nums = [-1, -1, -1, -1, -1, -1, -1]
queries = [[1,2], [3,3], [4,2]]
            i k

Initial nums: [1, 2, 2, 1, 2, 3, 1]
────────────────────────────────────────
Query [1,2]:
 → Mark index 1
 → Then mark 2 smallest unmarked → indices (0,3)
 → Unmarked sum = 2 + 2 + 3 + 1 = 8

Query [3,3]:
 → Index 3 already marked → skip
 → Mark 3 smallest unmarked → all except largest
 → Unmarked sum = 3

Query [4,2]:
 → Index 4 already marked → skip
 → Mark 2 smallest remaining → all marked
 → Unmarked sum = 0

Output: [8, 3, 0]

=========================================================================
=========================================================================

*/

class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {

        long[] result = new long[queries.length];
        long sum = 0;
        List<Pair> sortedNums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sortedNums.add(new Pair(nums[i], i));
        }

        sortedNums.sort(Comparator
                .comparingInt((Pair p) -> p.first)
                .thenComparingInt(p -> p.second));

        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int k = queries[i][1];

            if (nums[index] != -1) {
                sum -= nums[index];
                nums[index] = -1;
            }

            while (k > 0 && j < sortedNums.size()) {
                Pair current = sortedNums.get(j);
                if (nums[current.second] != -1) {
                    sum -= current.first;
                    nums[current.second] = -1;
                    k--;
                }
                j++;
            }

            result[i] = sum;
        }

        return result;
    }
}

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
