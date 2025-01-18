
class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        n = len(cardPoints)

        currentScore = sum(cardPoints[:k])
        maxScore = currentScore

        for i in range(k):
            currentScore += cardPoints[n - 1 - i]
            currentScore -= cardPoints[k - 1 - i]
            maxScore = max(maxScore, currentScore)

        return maxScore

# Time complexity - O(k)
# Space complexity - O (1)