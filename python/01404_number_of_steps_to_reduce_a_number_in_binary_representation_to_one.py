# n=5
# if even /2
# if odd +1

# Time complexity - O(n)
# Space complexity - O(1)
class Solution:
    def numSteps(self, s: str) -> int:
        steps = 0
        carry = 0

        # 5 => 101
        for i in range(len(s) - 1, 0, -1):
            if int(s[i]) + carry == 1: # Check the least significant bit (0) + carry
                # add 1 > 110
                # /2    > 11 (3)
                carry = 1
                steps += 2
            else:
                steps += 1

        return steps + carry
