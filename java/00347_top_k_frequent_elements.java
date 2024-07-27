import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// Time complexity -  O(n * log k),
// Space complexity - O(n + k)
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {   // O(n)
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> key : map.entrySet()) {  // O(n * log k)
            queue.offer(key);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {           // O(k * log k)
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}
