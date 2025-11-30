/*

Directed graph with n nodes labeled from 0 to n - 1;
where each node has exactly one outgoing edge

Example 1:
edges = [1,0,0,0,0,7,7,5]

Meaning:
Each node i points to edges[i]

0 → 1
1 → 0
2 → 0
3 → 0
4 → 0
5 → 7
6 → 7
7 → 5


Edge Score = sum of all indices that point to this node

Node | Incoming edges | Score
------------------------------
  0  | from [1,2,3,4]  | 1+2+3+4 = 10
  1  | from [0]        | 0
  5  | from [7]        | 7
  7  | from [5,6]      | 5+6 = 11

Highest edge score = 11 at node 7

Answer = 7


=========================================================================
=========================================================================


Example 2:
edges = [2,0,0,2]

0 → 2
1 → 0
2 → 0
3 → 2

Node | Incoming edges | Score
------------------------------
  0  | [1,2]          | 1+2 = 3
  2  | [0,3]          | 0+3 = 3

Both have score 3
Choose smallest index
Answer = 0

*/

public class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] score = new long[n];

        // Step 1: Calculate edge scores
        for (int i = 0; i < n; i++) {
            score[edges[i]] += i;
        }

        // Step 2: Find node with max score (tie → smallest index)
        long maxScore = -1;
        int node = 0;

        for (int i = 0; i < n; i++) {
            if (score[i] > maxScore) {
                maxScore = score[i];
                node = i;
            }
        }

        return node;
    }
}
