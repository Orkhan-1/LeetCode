/*

📘 Problem:
Given a nested list of integers, compute the sum of all integers weighted by
the reverse of their depth.

🧩 Example:
Input: [1,[4,[6]]]

Depth 1 → [ [ [6] ] ]
Depth 2 →   [4, [6]]
Depth 3 →     [1]
Weights (reverse): 1️⃣→3, 2️⃣→2, 3️⃣→1

Computation:
1 (depth 3) → 1 * 3 = 3
4 (depth 2) → 4 * 2 = 8
6 (depth 1) → 6 * 1 = 6
🎯 Total = 3 + 8 + 6 = 17

🧠 Approach (Two-Pass DFS):
1️⃣ First DFS → Find maximum depth (maxDepth)
2️⃣ Second DFS → Accumulate each value × (maxDepth - depth + 1)

⏱️ Time Complexity: O(N)
💾 Space Complexity: O(N)
*/


import java.util.*;

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // 1) find maximum depth
        int maxDepth = getMaxDepth(nestedList, 1);

        // 2) compute weighted sum
        return getWeightedSum(nestedList, 1, maxDepth);
    }

    private int getMaxDepth(List<NestedInteger> list, int depth) {
        int maxDepth = depth;
        for (NestedInteger ni : list) {
            if (!ni.isInteger()) {
                maxDepth = Math.max(maxDepth, getMaxDepth(ni.getList(), depth + 1));
            }
        }
        return maxDepth;
    }

    private int getWeightedSum(List<NestedInteger> list, int depth, int maxDepth) {
        int sum = 0;
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                int weight = maxDepth - depth + 1;
                sum += ni.getInteger() * weight;
            } else {
                sum += getWeightedSum(ni.getList(), depth + 1, maxDepth);
            }
        }
        return sum;
    }
}

public interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}
