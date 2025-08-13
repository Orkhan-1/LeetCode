class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        mod_map = {0: -1}  # remainder -> earliest index
        prefix_sum = 0

        for i, num in enumerate(nums):
            prefix_sum += num
            mod = prefix_sum % k if k != 0 else prefix_sum

            if mod in mod_map:
                if i - mod_map[mod] > 1:  # length at least 2
                    return True
            else:
                mod_map[mod] = i

        return False


# Time complexity - O(n)
# Space complexity - O(min(n, k))