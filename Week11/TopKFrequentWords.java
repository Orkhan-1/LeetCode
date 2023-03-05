import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        new TopKFrequentWords().topKFrequent(words,4);
    }

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (freq.containsKey(word)) {
                freq.put(word, freq.get(word) + 1);
            } else {
                freq.put(word, 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) :  b.getValue() - a.getValue()
        );

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
        }

        List<String> result = new ArrayList<>();
        while (k!=0) {
            result.add(pq.poll().getKey());
            k--;
        }
        return result;
    }
}
