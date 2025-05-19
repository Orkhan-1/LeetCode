class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])

        def rob_linear(houses: List[int]) -> int:
            prev1, prev2 = 0, 0
            for amount in houses:
                temp = prev1
                prev1 = max(prev2 + amount, prev1)
                prev2 = temp
            return prev1

        return max(rob_linear(nums[:-1]), rob_linear(nums[1:]))

# Time Complexity: O(n)
# Space Complexity: O(1)