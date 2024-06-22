import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

// Time complexity - O (1)
// Space complexity - O (N)
public class LFUCache {

    private Map<Integer, Node> lfuCache;
    private Map<Integer, Set<Integer>> frequencyMap;
    private int capacity;
    private int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        lfuCache = new HashMap<>();
        frequencyMap = new HashMap<>();
        frequencyMap.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {

        if (lfuCache.get(key) == null) {
            return -1;
        }

        Node node = lfuCache.get(key);
        int currentFreq = node.freq;
        node.freq++;
        lfuCache.put(key, node);

        frequencyMap.get(currentFreq).remove(key); // 2
        int newFreq = currentFreq + 1; // 3
        if (currentFreq == minFrequency && frequencyMap.get(currentFreq).isEmpty()) {
            minFrequency = newFreq;
        }

        Set<Integer> freqKeys = frequencyMap.get(newFreq);

        if (freqKeys == null) {
            freqKeys = new LinkedHashSet<>();
        }
        freqKeys.add(key);
        frequencyMap.put(newFreq, freqKeys);
        return node.val;
    }

    public void put(int key, int value) {
        if (lfuCache.get(key) != null) {
            Node node = lfuCache.get(key);
            node.val = value;
            lfuCache.put(key, node);
            get(key);
        } else {
            if (lfuCache.size() == capacity) {
                int remove = frequencyMap.get(minFrequency).iterator().next(); // 2 keys 3,4,5,6
                lfuCache.remove(remove);
                frequencyMap.get(minFrequency).remove(remove);
            }
            Node newNode = new Node(value, 1);
            lfuCache.put(key, newNode);
            Set<Integer> freqKeys = frequencyMap.get(1);
            freqKeys.add(key);
            frequencyMap.put(1, freqKeys);
            minFrequency = 1;
        }
    }

    class Node {
        int val;
        int freq;

        Node(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
}