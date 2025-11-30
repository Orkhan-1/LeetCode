/*

Example 1:
s = "aba"

Start: "a b a"
Remove: "a" and "b" (different adjacent) → "a"
Final: "a"

Input: "aba"
Output: 1

=========================================================================
=========================================================================

Example 2:
s = "aabb"

Start: "a a b b"

Remove: "a" and "b" → "a b"
Remove: "a" and "b" → ""
Final: ""

Input: "aabb"
Output: 0

=========================================================================
=========================================================================

Example 3:
s = "aaaa"

Start: "a a a a"
No removals possible (all characters same)
Final: "aaaa"

Input: "aaaa"
Output: 4

s = "aaaa"

*/


class Solution {
    public int minLengthAfterRemovals(String s) {
        int countA = 0;
        int countB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                countA++;
            } else {
                countB++;
            }
        }
        return Math.abs(countA - countB);
    }
}