import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length<k) {
            return Integer.MIN_VALUE;
        }

        Queue<Integer> heap =
                new PriorityQueue<>(Comparator.comparingInt(n -> n));

        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        return heap.poll();
    }

}
