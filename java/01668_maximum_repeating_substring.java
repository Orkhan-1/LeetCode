/*
Example 1:
sequence = "ababc"
word     = "ab"

    a  b  a  b  c
    ↑__↑__
    "ab" → 1
    "abab" → 2

Maximum repeating = 2

=========================================================================
=========================================================================

Example 2:
sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba"
word     = "aaaba"

            aaaba|aaaba|aaaba|aaaba|aaaba

Maximum repeating = 5

=========================================================================
=========================================================================

Example 3:
sequence = "abc"
word     = "z"

Maximum repeating = 0

*/


public class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String repeated = word;

        while (sequence.contains(repeated)) {
            count++;
            repeated += word;
        }

        return count;
    }
}
