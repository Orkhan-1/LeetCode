# Time complexity - O (n), canReach is called for each index once
# Space complexity - O (n), dp and at most n recursive call

class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        dp = [None] * len(arr)
        return self.canReachHelper(arr, start, dp)

    def canReachHelper(self, arr: List[int], position: int, dp: List[int]) -> bool:
        if position < 0 or position >= len(arr):
            return False

        if arr[position] == 0:
            return True

        if dp[position] is not None:
            return dp[position]

        dp[position] = False

        canReachZero = self.canReachHelper(arr, position + arr[position], dp) or \
                       self.canReachHelper(arr, position - arr[position], dp)

        dp[position] = canReachZero
        return dp[position]
