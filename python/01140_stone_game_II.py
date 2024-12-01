#     Python
# Time complexity - O(n^3)
# Space complexity - O(n^2)
class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        def getMaxScore(turn: bool, m: int, index: int, memo: dict) -> int:
            if index >= len(piles):
                return 0

            key = (index, m, turn)
            if key in memo:
                return memo[key]

            maxScore = float('-inf') if turn else float('inf')
            tempScore = 0

            for x in range(1, 2 * m + 1):
                if index + x > len(piles):
                    break

                tempScore += piles[index + x - 1]

                if turn:
                    maxScore = max(maxScore, tempScore + getMaxScore(False, max(m, x), index + x, memo))
                else:
                    maxScore = min(maxScore, getMaxScore(True, max(m, x), index + x, memo))

            memo[key] = maxScore
            return maxScore

        memo = {}
        return getMaxScore(True, 1, 0, memo)
