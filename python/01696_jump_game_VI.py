# Time complexity - O (N)
# Space complexity - O (N)
class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        n = len(nums)
        dp = [0] * n
        dp[0] = nums[0]

        dq = deque()
        dq.append(0)

        for i in range(1, n):
            dp[i] = nums[i] + dp[dq[0]]

            while dq and dq[0] <= i - k:
                dq.popleft()

            while dq and dp[dq[-1]] <= dp[i]:
                dq.pop()

            dq.append(i)

        return dp[-1]
