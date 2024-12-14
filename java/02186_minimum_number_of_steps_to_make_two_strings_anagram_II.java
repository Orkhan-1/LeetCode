//       Java
// Time complexity - O (N)
// Space complexity - O (1)

// example: s = "abc" ; t = "bcd"
// freq: a = 1, b = 1, c = 1
// freq: a = 1, b = 0, c = 0, d = -1

public class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        int steps = 0;
        for (int count : freq) {
            steps += Math.abs(count);
        }

        return steps;
    }
}
