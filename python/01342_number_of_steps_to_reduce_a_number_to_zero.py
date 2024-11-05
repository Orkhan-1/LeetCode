# n=14
 # if even /2
 # if odd -1

 # 14 => 1110
 # if even /2 [Check the least significant bit (0)  => right shift 1110 > 0111]
 # if odd -1  [Check the least significant bit (1)  => flip 0111 > 0110]


# Time complexity - O(log n)
# Space complexity - O(1)
class Solution:
    def numberOfSteps(self, num: int) -> int:
        steps = 0

        while num != 0:
            if (num & 1) == 0:
                num >>= 1
            else:
                num &= ~1
            steps += 1

        return steps
