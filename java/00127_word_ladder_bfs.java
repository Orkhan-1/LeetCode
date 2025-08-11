class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Preprocess: map intermediate patterns to words
        Map<String, List<String>> patternMap = new HashMap<>();
        int L = beginWord.length();
        for (String word : wordSet) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // BFS
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                for (String neighbor : patternMap.getOrDefault(pattern, Collections.emptyList())) {
                    if (neighbor.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(new Pair<>(neighbor, level + 1));
                    }
                }
            }
        }
        return 0;
    }

}

// Time complexity -  O(N × L)
// Space complexity - O(N × L)