/*
🧩 Problem

Find the average salary after excluding the minimum
and maximum salary.

Example:

salary = [4000, 3000, 1000, 2000]

Minimum = 1000
Maximum = 4000

Remaining:
3000 + 2000 = 5000

Average:
5000 / 2 = 2500.0

------------------------------------------------------------

🔑 Key Observation:

We don't need to sort the array.

During one loop, track:

    sum → total salary
    min → minimum salary
    max → maximum salary

After the loop:

sum = sum - min - max

Average:

(double) sum / (salary.length - 2)

------------------------------------------------------------

🧾 Time Complexity:

O(n)

One pass through the array.

🧾 Space Complexity:

O(1)

Only sum, min, and max are used.
*/

class Solution {
    public double average(int[] salary) {

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < salary.length; i++) {

            sum += salary[i];

            if (salary[i] < min) {
                min = salary[i];
            }

            if (salary[i] > max) {
                max = salary[i];
            }
        }

        sum = sum - min - max;

        return (double) sum / (salary.length - 2);
    }
}