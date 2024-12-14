#       Python
# Time complexity - O (N)
# Space complexity - O (1)

# example: s = "deeedbbcccbdaa", k = 3
#          s = "deeedbbcccbdaa"

class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []  # character, count

        for char in s:
            if stack and stack[-1][0] == char:
                stack[-1][1] += 1
                if stack[-1][1] == k:
                    stack.pop()
            else:
                stack.append([char, 1])

        result = ''.join(char * count for char, count in stack)
        return result