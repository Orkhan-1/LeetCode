import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// Time complexity -  O(N log K) - N is the length of the result string, and log K is the height of the max heap
// Space complexity - O(N)
public class SortCharactersByFrequency {

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Character> maxHeap = new PriorityQueue<>((a, b) ->
                map.get(b) - map.get(a));

        maxHeap.addAll(map.keySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char currentChar = maxHeap.poll();
            int frequency = map.get(currentChar);
            for (int i = 0; i < frequency; i++) {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}
