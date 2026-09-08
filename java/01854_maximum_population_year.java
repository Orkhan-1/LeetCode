/*

🧩 Problem:

Maximum Population Year

💡 Setup:

You are given an array of birth and death years.

Each person is alive from their birth year
up to, but not including, their death year.

Return the year with the maximum population.

If multiple years have the same population,
return the earliest year.

------------------------------------------------------------

💡 Example:

Input:

logs = [
    [1993, 1999],
    [2000, 2010]
]

Population:

1993 → 1
1994 → 1
...
1998 → 1

2000 → 1
...
2009 → 1

Output:

1993

------------------------------------------------------------

🧠 Key Insight:

Use a difference array to track when the
population changes.

For each person:

    population[birth]++

    population[death]--

The population at each year is obtained by
adding the changes from previous years.

While calculating the running population,
keep track of the maximum population and
the earliest year where it occurs.

------------------------------------------------------------

🧾 Time Complexity:

O(n + k)

n = number of people
k = range of years

------------------------------------------------------------

🧾 Space Complexity:

O(k)

The difference array stores the population
changes for each year.

*/

class Solution {
    public int maximumPopulation(int[][] logs) {

        // Difference array for years 1950 - 2050
        int[] population = new int[101];

        // Record population changes
        for (int[] log : logs) {
            population[log[0] - 1950]++;
            population[log[1] - 1950]--;
        }

        int maxPopulation = 0;
        int currentPopulation = 0;
        int answer = 1950;

        // Calculate running population
        for (int i = 0; i < population.length; i++) {
            currentPopulation += population[i];

            // Update only when population is greater
            // to keep the earliest year on ties
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                answer = i + 1950;
            }
        }

        return answer;
    }
}
```
