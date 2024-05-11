from typing import List


# Time complexity - O (N)
# Space complexity - O (1)
class Solution:
    def countElements(self, nums: List[int]) -> int:
        result = 0
        min_val = float('inf')
        max_val = float('-inf')

        for num in nums:
            min_val = min(min_val, num)
            max_val = max(max_val, num)

        for num in nums:
            if min_val < num < max_val:
                result += 1

        return result