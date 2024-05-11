from typing import List


#       Python
# Time complexity - O (N)
# Space complexity - O (1)
class Solution:
    def numPairsDivisibleBy60 (self, time: List[int]) -> int:
        remainder_count = {}
        result = 0

        for t in time:
            remainder = t % 60
            complement = (60 - remainder) % 60
            result += remainder_count.get(complement, 0)
            remainder_count[remainder] = remainder_count.get(remainder, 0) + 1
        return result
