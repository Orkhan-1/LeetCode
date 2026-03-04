/*

🧩 Problem:
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either:
- an integer 🔢
- or a nested list 📦 that contains more integers or lists.

------------------------------------
Example 1:
Input: [[1,1],2,[1,1]]

🌳 Tree Representation:
           (root)
         /    |     \
     📦      🔢2     📦
    /  \            /  \
 🔢1   🔢1        🔢1   🔢1

Depth Levels:
Level 1 ➤ [ [1,1], 2, [1,1] ]
Level 2 ➤ [ 1,1,1,1 ]

Computation:
Level 1: 2 * 1 = 2
Level 2: (1+1+1+1) * 2 = 8
Total = 10 ✅

------------------------------------
Approach 🧠:
Perform DFS recursion:
- If element is 🔢 integer → multiply by depth
- If element is 📦 list → recursive call (depth+1)

------------------------------------
Complexity:
Time  = O(N)  — visit each integer once
Space = O(D)  — recursion depth
*/

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += dfs(ni.getList(), depth + 1);
            }
        }
        return sum;
    }
}