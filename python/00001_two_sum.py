# Time complexity - O (N)
# Space complexity - O (N)

# nums = [2,7,11,15], target = 13 (exatly one solution)
# [2-0, 7-1] 13 - 2

from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_map = {}

        for i, num in enumerate(nums):
            complement = target - num

            if complement in num_map:
                return [num_map[complement], i]

            num_map[num] = i
        return []

