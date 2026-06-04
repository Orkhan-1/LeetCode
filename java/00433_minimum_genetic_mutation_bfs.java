/*

Minimum Genetic Mutation

🧬 Start: AACCGGTT
🧬 End  : AAACGGTA

Bank:
[AACCGGTA, AACCGCTA, AAACGGTA]

--------------------------------------------------

Think of each gene as a node in a graph.

Two genes are connected if they differ by
exactly ONE character.

Graph:

AACCGGTT
    │
    ▼
AACCGGTA
   ╱
  ▼
AAACGGTA 🎯

--------------------------------------------------

BFS 🚀

Root node startGene.

For every gene removed from the queue:

1. Scan all remaining genes in bank.
2. If a gene differs by exactly 1 character:
      ✅ reachable in one mutation
      ✅ add to queue
      ✅ remove from bank

Example:

Current:
AACCGGTT

Bank:
[AACCGGTA, AACCGCTA, AAACGGTA]

Compare:

AACCGGTT vs AACCGGTA
       ↑
Only 1 difference ✅

Enqueue:
AACCGGTA

Remove from bank so we never visit again.

--------------------------------------------------

Why BFS Works 🎯

Level 0:
AACCGGTT

Level 1:
AACCGGTA

Level 2:
AAACGGTA 🎯

Each BFS level represents exactly one additional mutation.

Therefore, the first time we reach endGene,
we have found the minimum number of mutations.

*/

import java.util.*;

class Solution {

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endGene)) {
                    return mutations;
                }

                Iterator<String> it = bankSet.iterator();
                List<String> toEnqueue = new ArrayList<>();
                while (it.hasNext()) {
                    String candidate = it.next();
                    if (diffByOne(current, candidate)) {
                        toEnqueue.add(candidate);
                        it.remove();
                    }
                }
                queue.addAll(toEnqueue);
            }

            mutations++;
        }

        return -1;
    }

    private boolean diffByOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
}