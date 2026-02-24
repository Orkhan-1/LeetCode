/*

Problem:
You are given a list of words and will be asked repeatedly to find
the shortest distance between two given words in that list.

----------------------------------------------------------
📊 Example:

words = ["practice","makes","perfect","coding","makes"]
index:     0          1         2          3         4

word1 = "coding" → positions [3]
word2 = "practice" → positions [0]
📏 |3 - 0| = 3 ✅

word1 = "makes" → [1, 4]
word2 = "coding" → [3]
🔁 compare:
  |1 - 3| = 2
  |4 - 3| = 1 ✅ min = 1

----------------------------------------------------------
⏱️ Time:
Constructor: O(N)
Query shortest(): O(L1 + L2)
   (where L1, L2 are counts of occurrences of the two words)
Space: O(N)
*/

import java.util.*;

class WordDistance {
    private Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            map.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0, min = Integer.MAX_VALUE;

        while (i < list1.size() && j < list2.size()) {
            int idx1 = list1.get(i), idx2 = list2.get(j);
            min = Math.min(min, Math.abs(idx1 - idx2));

            // Move the smaller index forward
            if (idx1 < idx2) i++;
            else j++;
        }
        return min;
    }
}