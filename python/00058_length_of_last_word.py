#       Python
# Time complexity - O (N)
# Space complexity - O (1)

# example 1: "The weather is rainy"
# example 2: "HelloWorld   "

class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        size = 0
        start = len(s) - 1

        # Move the pointer `start` backward to skip any trailing spaces
        while start >= 0 and s[start] == ' ':
            start -= 1

        # Count the length of the last word
        while start >= 0 and s[start] != ' ':
            size += 1
            start -= 1

        return size
