
# Example:
# Input: score = [10, 3, 8, 9, 4] => ["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"]

# Steps:
# 1. Pair each score with its index: [(10, 0), (3, 1), (8, 2), (9, 3), (4, 4)]
# 2. Sort the pairs by score:        [(10, 0), (9, 3), (8, 2), (4, 4), (3, 1)]

# 3. Map ranks                  ["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"]


# Time complexity - O(n log n)
# Space complexity - O (n)

class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        score_with_indices = [(s, i) for i, s in enumerate(score)]

        sorted_scores = sorted(score_with_indices, key=lambda x: x[0], reverse=True)

        result = [""] * len(score)

        for rank, (s, i) in enumerate(sorted_scores):
            if rank == 0:
                result[i] = "Gold Medal"
            elif rank == 1:
                result[i] = "Silver Medal"
            elif rank == 2:
                result[i] = "Bronze Medal"
            else:
                result[i] = str(rank + 1)

        return result
