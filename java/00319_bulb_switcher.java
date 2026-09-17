/*



🧩 Problem

We have n bulbs, initially OFF.

Example: n = 10

Initially:

OFF OFF OFF OFF OFF OFF OFF OFF OFF OFF

Round 1 → Toggle every bulb:

💡  💡   💡  💡  💡   💡  💡  💡  💡   💡
ON  ON  ON  ON  ON  ON  ON  ON  ON  ON


Round 2 → Toggle every 2nd bulb:

💡       💡      💡      💡      💡
ON  OFF ON  OFF ON  OFF ON  OFF ON  OFF


Round 3 → Toggle every 3rd bulb:

💡               💡       💡      💡
ON  OFF OFF OFF ON  OFF  ON  OFF ON  OFF

.
.
.
                                    💡
Return the number of bulbs that are ON after n rounds

------------------------------------------------------------

Instead of simulating every round, look at ONE bulb.

💡 Bulb #6

It gets toggled in rounds:

1, 2, 3, 6

Because these are the divisors of 6.

4 toggles → OFF

------------------------------------------------------------

💡 Bulb #9

It gets toggled in rounds:

1, 3, 9

3 toggles → ON

------------------------------------------------------------

🔑 Key Observation:

A bulb is toggled once for every divisor of its position.

Most numbers have divisors in pairs:

12 → (1,12), (2,6), (3,4)
     → 6 divisors → OFF

Perfect squares have one unpaired divisor:

9 → (1,9), (3,3)
              ↑
         pairs with itself

     → 3 divisors → ON

------------------------------------------------------------

Therefore:

Perfect square → ON
Non-perfect square → OFF

For n = 10:

💡          💡                 💡
ON OFF OFF ON OFF OFF OFF OFF ON OFF
↑          ↑                  ↑
1          4                  9

Perfect squares:

1, 4, 9

Answer = 3

------------------------------------------------------------

💡 Final Formula:

Number of perfect squares <= n

= floor(√n)

------------------------------------------------------------

🧾 Time Complexity:

O(1)

🧾 Space Complexity:

O(1)
*/

class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n); // 10 ==> 3.1622776601683795
    }
}