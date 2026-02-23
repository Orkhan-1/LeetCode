/*

🎯 Goal
Sum all integers in a nested list with weights from bottom → top.

🌳 Example Input: [1,[4,[6]]]
Visualized as a tree (depth ↓)

Level 1:   1
            \
Level 2:     4
               \
Level 3:        6

🏷️ Depth weights (bottom-up)
6 → weight 1
4 → weight 2
1 → weight 3

🎯 Calculation
= 6×1 + 4×2 + 1×3
= 6 + 8 + 3 = 17 ✅

🪜 Steps
1️⃣ Find max depth
2️⃣ Sum each integer × (maxDepth - depth + 1)

⏱️ O(N) time | 🧠 O(D) space
*/

interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    java.util.List<NestedInteger> getList();
}

public class Solution {

    public int depthSumInverse(java.util.List<NestedInteger> nestedList) {
        int maxDepth = findMaxDepth(nestedList, 1);
        return sum(nestedList, 1, maxDepth);
    }

    private int findMaxDepth(java.util.List<NestedInteger> list, int depth) {
        int max = depth;
        for (NestedInteger ni : list)
            if (!ni.isInteger()) {
                max = Math.max(max, findMaxDepth(ni.getList(), depth + 1));
            }

        return max;
    }

    private int sum(java.util.List<NestedInteger> list, int depth, int maxDepth) {
        int total = 0;
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                total += ni.getInteger() * (maxDepth - depth + 1);
            } else {
                total += sum(ni.getList(), depth + 1, maxDepth);
            }
        }
        return total;
    }
}