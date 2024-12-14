# Python
# Time complexity - O(N)
# Space complexity - O(1)

# gas =  [1, 2, 3, 4, 5]
# cost = [3, 4, 5, 1, 2]

# total_gas
# current_gas
# start_station = 3 [Only 1 start_station if solution exist]

from typing import List

class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total_gas = 0
        current_gas = 0
        start_station = 0

        for i in range(len(gas)):
            current = gas[i] - cost[i]
            total_gas += current
            current_gas += current

            # If we can't proceed further, reset start_station
            if current_gas < 0:
                start_station = i + 1
                current_gas = 0

        return start_station if total_gas >= 0 else -1
