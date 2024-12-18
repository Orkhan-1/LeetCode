# Time complexity - O (N^2)
# Space complexity - O (1) - no additional memory is allocated except the output

# nums = [-1, 0, 1, 2, -1]
# nums = [-1, -1, 0, 1, 2]

# -1 [-1, 0, 1, 2]
# result = [[-1, -1, 2], [-1, 0, 1]]

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()

        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            left, right = i + 1, len(nums) - 1

            while left < right:
                total = nums[i] + nums[left] + nums[right]

                if total == 0:
                    result.append([nums[i], nums[left], nums[right]])

                    # Skip duplicates
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1

                    left += 1
                    right -= 1
                elif total < 0:
                    left += 1
                else:
                    right -= 1

        return result
