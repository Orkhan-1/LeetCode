//       Java
// Time complexity - O (N)
// Space complexity - O (1)

// gas =  [1, 2, 3, 4, 5]
// cost = [3, 4, 5, 1, 2]

// total_gas
// current_gas
// start_station = 3 [Only 1 start_station if solution exist]

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currentGas = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int current = gas[i] - cost[i];
            totalGas += current;
            currentGas += current;

            if (currentGas < 0) {
                startStation = i + 1;
                currentGas = 0;
            }
        }

        return totalGas >= 0 ? startStation : -1;
    }
}