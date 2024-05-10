from typing import List


class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        remainder_count = {}
        count = 0

        for t in time:
            remainder = t % 60
            complement = (60 - remainder) % 60
            count += remainder_count.get(complement, 0)
            remainder_count[remainder] = remainder_count.get(remainder, 0) + 1
        return count


solution = Solution()
time = [30, 20, 150, 100, 40]
print(solution.numPairsDivisibleBy60(time))  # Output: 3
