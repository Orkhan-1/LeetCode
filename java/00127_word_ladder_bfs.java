/*


🧩 Problem:

- beginWord (e.g. "hit")
- endWord (e.g. "cog")
- wordList (e.g. ["hot","dot","dog","lot","log","cog"])

You can change only one letter at a time,
and each transformed word must exist in the word list.

Return the length of the shortest transformation sequence 
from beginWord to endWord.
If not possible → return 0.

---------------------------

🎯 Example:
beginWord = "hit"
endWord   = "cog"
wordList  = ["hot","dot","dog","lot","log","cog"]

Transformation path:
hit → hot → dot → dog → cog

🪜 Steps:
hit 
 🔻 change 'i'→'o'
hot 
 🔻 change 'h'→'d'
dot 
 🔻 change 't'→'g'
dog 
 🔻 change 'g'→'c'
cog ✅

Length = 5

---------------------------

⏱️ Time Complexity: O(N * L²)
   - N = number of words
   - L = length of each word
   Because we explore each word and try L * 26 transformations.

💾 Space Complexity: O(N)
   - for the queue + set

*/

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return steps;
                }

                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) { // hit -> hot
                        if (c == original) {
                            continue;
                        }
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    chars[j] = original;
                }
            }
            steps++;
        }

        return 0;
    }
}