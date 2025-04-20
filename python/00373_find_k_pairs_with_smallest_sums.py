class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        if not nums1 or not nums2 or k == 0:
            return []

        heap = []
        result = []

        for i in range(min(k, len(nums1))):
            heapq.heappush(heap, (nums1[i] + nums2[0], nums1[i], nums2[0], 0))

        while k > 0 and heap:
            current = heapq.heappop(heap)
            num1 = current[1]
            num2 = current[2]
            index2 = current[3]

            result.append([num1, num2])

            if index2 + 1 < len(nums2):
                next_num2 = nums2[index2 + 1]
                heapq.heappush(heap, (num1 + next_num2, num1, next_num2, index2 + 1))

            k -= 1

        return result