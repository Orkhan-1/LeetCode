/*

🧠 Build an autocomplete system that suggests the top 3 historical sentences
   matching current typed prefixes, ordered by frequency and lexicographically.

   📌 Example:
Input sentences:
   ["i love you", "island", "iroman", "i love coding"]
Frequencies:
   [5, 3, 2, 2]

Typing:
   i → returns ["i love you","island","i love coding"]
   ' '→ ["i love you","i love coding"]
   l → ["i love you","i love coding"]
   # → ends input "i l" → add to history

📌 Approach: Trie + Min-Heap for top suggestions on each prefix

📍 We maintain a Trie where each node contains:
   - children: next chars
   - Map of sentence → frequency that pass through that node

🚀 As user types characters:
   - If char != '#', we traverse the Trie and retrieve top 3 matches
   - If char == '#', we insert/update the full sentence in the Trie

🔁 Constraints:
   - Frequent suggestions sorted by:
      1) desc freq
      2) lexicographically asc
*/

public class AutocompleteSystem {

    private final TrieNode root;
    private TrieNode curr;
    private StringBuilder prefix;

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        curr = root;
        prefix = new StringBuilder();

        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    private void insert(String sentence, int freq) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) { // i
            node.children.putIfAbsent(c, new TrieNode()); // i
            node = node.children.get(c); // get i
            node.counts.put(sentence, node.counts.getOrDefault(sentence, 0) + freq);
            // children: [i: new TrieNode] counts [i love you: 3]
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            String completed = prefix.toString();
            insert(completed, 1);
            prefix = new StringBuilder();
            curr = root;
            return Collections.emptyList();
        }

        prefix.append(c);
        if (curr != null && curr.children.containsKey(c)) {
            curr = curr.children.get(c);
        } else {
            curr = null;
            return Collections.emptyList();
        }

        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>(
                        (a, b) -> a.getValue().equals(b.getValue())
                                ? b.getKey().compareTo(a.getKey())  // lex desc for min
                                : a.getValue() - b.getValue()       // freq asc for min
                );

        for (Map.Entry<String, Integer> entry : curr.counts.entrySet()) {
            pq.offer(entry);
            if (pq.size() > 3) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }
        // reverse to highest priority first
        Collections.reverse(result);
        return result;
    }
}