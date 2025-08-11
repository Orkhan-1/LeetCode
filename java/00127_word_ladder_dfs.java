class Solution {

    int minSize = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, Set<String>> words = new HashMap<>();

        // n^3
        for (int i = 0; i < beginWord.length(); i++) {
            for (String word : wordList) {
                for (int j = 0; j < word.length(); j++) {
                    if (i == j) {
                        continue;
                    }
                    if (beginWord.charAt(j) != word.charAt(j)) {
                        break;
                    }
                    if (j == word.length() - 1) {
                        Set<String> sets = words.get(beginWord);

                        if (sets != null) {
                            sets.add(word);
                            words.put(beginWord, sets);
                        } else {
                            Set<String> newSet = new HashSet<>();
                            newSet.add(word);
                            words.put(beginWord, newSet);
                        }
                    }
                }
            }
        }

        //n^4
        for (int i = 0; i < wordList.size(); i++) {

            String currentWord = wordList.get(i);

            if (currentWord.equals("dot")) {
                System.out.println("Found dog at index: " + i);
            }


            for (int k = 0; k < currentWord.length(); k++) {


                for (String word : wordList) {

                    if (word.equals(currentWord)) {
                        continue;
                    }
                    for (int j = 0; j < word.length(); j++) {
                        if (k == j && j != word.length() - 1) {
                            continue;
                        }
                        if (currentWord.charAt(j) != word.charAt(j) && j != k) {
                            break;
                        }
                        if (j == word.length() - 1) {
                            Set<String> sets = words.get(currentWord);

                            if (sets != null) {
                                sets.add(word);
                                words.put(currentWord, sets);
                            } else {
                                Set<String> newSet = new HashSet<>();
                                newSet.add(word);
                                words.put(currentWord, newSet);
                            }
                        }
                    }
                }
            }

        }

        Set<String> beginWords = words.get(beginWord);

        if (beginWords == null) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        for (String word : beginWords) {
            visited.add(word);
            dfs(word, words, endWord, 1, visited);
            visited.remove(word);
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize + 1;
    }

    private void dfs(String word, Map<String, Set<String>> words, String endWord, int size, Set<String> visited) {
        Set<String> currentWords = words.get(word);

        if (currentWords == null) {
            return;
        }

        for (String currentWord : currentWords) {

            if (endWord.equals(currentWord)) {
                minSize = Math.min(minSize, size + 1);
            }

            if (visited.contains(currentWord)) {
                continue;
            }
            visited.add(currentWord);
            dfs(currentWord, words, endWord, size + 1, visited);
            visited.remove(currentWord);
        }
    }
}