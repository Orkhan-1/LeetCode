import heapq

# Time complexity - addNum: O(log n) heap operations, findMedian: O(1)
# Space complexity - O (N)
class MedianFinder:
    def __init__(self):
        self.max_heap = []
        self.min_heap = []

     # 1,2,3,4,5
     # Max Heap - smaller half: 1,2,3
     # Min Heap - larger half: 4,5
    def addNum(self, num: int) -> None:
        heapq.heappush(self.max_heap, -num)

        if (self.max_heap and self.min_heap and
                (-self.max_heap[0] > self.min_heap[0])):
            heapq.heappush(self.min_heap, -heapq.heappop(self.max_heap))  # Max-Heap: 1,2,4 //Min-Heap: 3
                                                                          # Max-Heap: 1,2 //Min-Heap: 3,4
        # balance
        if len(self.max_heap) > len(self.min_heap) + 1:
            heapq.heappush(self.min_heap, -heapq.heappop(self.max_heap))
        elif len(self.min_heap) > len(self.max_heap):
            heapq.heappush(self.max_heap, -heapq.heappop(self.min_heap))

    def findMedian(self) -> float:
        if len(self.max_heap) > len(self.min_heap):
            return float(-self.max_heap[0])
        else:
            return (-self.max_heap[0] + self.min_heap[0]) / 2.0
