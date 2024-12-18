# Time complexity - O (N^3)
# Space complexity - O (1) - no additional memory is allocated except the output

# nums = [1, 0, -1, 0, -2, 2]
# nums = [-2, -1, 0, 0, 1, 2]

# -2, -1 [0, 0, 1, 2]
# result = [-2, -1, 1, 2]

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        result = []
        if nums is None or len(nums) < 4:
            return result

        nums.sort()
        n = len(nums)

        for i in range(n - 3):
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            for j in range(i + 1, n - 2):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue

                left, right = j + 1, n - 1

                while left < right:
                    total = nums[i] + nums[j] + nums[left] + nums[right]

                    if total == target:
                        result.append([nums[i], nums[j], nums[left], nums[right]])

                        while left < right and nums[left] == nums[left + 1]:
                            left += 1
                        while left < right and nums[right] == nums[right - 1]:
                            right -= 1

                        left += 1
                        right -= 1
                    elif total < target:
                        left += 1
                    else:
                        right -= 1

        return result
