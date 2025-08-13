class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Make sure nums1 is the smaller array to reduce binary search range
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2; // Number of elements in the left partition

        int left = 0;
        int right = m; // Search space in nums1

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = totalLeft - partitionA; // Remaining elements go to nums2

            // If partition is at index 0, maxLeft is -∞ (no elements on left)
            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            // Check if we have the perfect partition
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // If total length is odd, median is max of left side
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeftA, maxLeftB);
                }
                // If even, median is average of maxLeft and minRight
                return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
            }
            // Move search space
            else if (maxLeftA > minRightB) {
                right = partitionA - 1; // Move left
            } else {
                left = partitionA + 1; // Move right
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}

// Time complexity - O(log(min(m, n)))
// Space complexity - O(1)

