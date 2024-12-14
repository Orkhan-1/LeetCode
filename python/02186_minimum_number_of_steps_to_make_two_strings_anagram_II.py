#       Python
# Time complexity - O (N)
# Space complexity - O (1)

# example: s = "abc" ; t = "bcd"
# freq: a = 1, b = 1, c = 1
# freq: a = 1, b = 0, c = 0, d = -1

class Solution:
    def minSteps(self, s: str, t: str) -> int:
        freq = [0] * 26

        for char in s:
            freq[ord(char) - ord('a')] += 1

        for char in t:
            freq[ord(char) - ord('a')] -= 1

        return sum(abs(count) for count in freq)
