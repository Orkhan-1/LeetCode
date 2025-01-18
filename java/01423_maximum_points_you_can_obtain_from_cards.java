class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int currentScore = 0;
        for (int i = 0; i < k; i++) {
            currentScore += cardPoints[i];
        }

        int maxScore = currentScore;

        for (int i = 0; i < k; i++) {
            currentScore += cardPoints[n - 1 - i];
            currentScore -= cardPoints[k - 1 - i];
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}

// Time complexity - O(k)
// Space complexity - O (1)
