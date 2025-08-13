from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # Ensure nums1 is the smaller array
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        m, n = len(nums1), len(nums2)
        total_left = (m + n + 1) // 2

        left, right = 0, m

        while left <= right:
            partitionA = (left + right) // 2
            partitionB = total_left - partitionA

            maxLeftA = float('-inf') if partitionA == 0 else nums1[partitionA - 1]
            minRightA = float('inf') if partitionA == m else nums1[partitionA]

            maxLeftB = float('-inf') if partitionB == 0 else nums2[partitionB - 1]
            minRightB = float('inf') if partitionB == n else nums2[partitionB]

            # Check if we found the correct partition
            if maxLeftA <= minRightB and maxLeftB <= minRightA:
                if (m + n) % 2 == 1:
                    return max(maxLeftA, maxLeftB)
                else:
                    return (max(maxLeftA, maxLeftB) + min(minRightA, minRightB)) / 2.0
            elif maxLeftA > minRightB:
                right = partitionA - 1
            else:
                left = partitionA + 1

        raise ValueError("Input arrays are not sorted.")

# Time complexity - O(log(min(m, n)))
# Space complexity - O(1)