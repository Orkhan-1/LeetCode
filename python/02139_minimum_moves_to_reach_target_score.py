#                   EXAMPLE 1
# target = 5, maxDoubles = 0
# start = 1

# Each step: +1
#            *2

# Reach target: start == target => with minimum steps

# target = 5, maxDoubles = 0 ==> steps = 4


#                   EXAMPLE 2
# target = 19, maxDoubles = 2 ==> Greedy Algorithm
# start = 1

# steps = 7



class Solution:
    def minMoves(self, target: int, maxDoubles: int) -> int:
        steps = 0

        while target > 1 and maxDoubles > 0:
            if target % 2 == 0:
                target //= 2
                maxDoubles -= 1
            else:
                target -= 1
            steps += 1

        return steps + (target - 1)


# Time complexity - O(log(target))
# Space complexity - O (1)