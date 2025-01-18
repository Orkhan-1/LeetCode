// Time complexity - O(n log n)
// Space complexity - O (n)

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        int[][] scoresWithIndices = new int[n][2];

        for (int i = 0; i < n; i++) {
            scoresWithIndices[i][0] = score[i];
            scoresWithIndices[i][1] = i;
        }

        Arrays.sort(scoresWithIndices, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            int index = scoresWithIndices[i][1];
            if (i == 0) {
                result[index] = "Gold Medal";
            } else if (i == 1) {
                result[index] = "Silver Medal";
            } else if (i == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(i + 1);
            }
        }

        return result;
    }
}
