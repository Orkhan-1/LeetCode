import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {
        new ReorganizeString().reorganizeString("aaab");
    }

    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        queue.addAll(map.entrySet());
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> first = queue.poll();
            result.append(first.getKey());
            first.setValue(first.getValue() - 1);
            Map.Entry<Character, Integer> second;
            if (!queue.isEmpty()) {
                second = queue.poll();
                result.append(second.getKey());
                second.setValue(second.getValue() - 1);
            } else {
                if (first.getValue() > 0) {
                    return "";
                } else {
                    return result.toString();
                }
            }
            if (first.getValue() > 0) {
                queue.offer(first);
            }
            if (second != null && second.getValue() > 0) {
                queue.offer(second);
            }
        }
        return result.toString();
    }
}
