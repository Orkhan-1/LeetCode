#        Python
# Time complexity -  O (N)
# Space complexity - O (1)

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        result = 0
        for num in nums:
            result ^= num # 2 2 1
        return result