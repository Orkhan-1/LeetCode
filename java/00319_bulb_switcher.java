/*



🧩 Problem:

Bulb Switcher

💡 Example:

Suppose n = 10 bulbs

Initially:
💡 💡 💡 💡 💡 💡 💡 💡 💡 💡
ON ON ON ON ON ON ON ON ON ON

Round 1:
Toggle every bulb
❌ ❌ ❌ ❌ ❌ ❌ ❌ ❌ ❌ ❌

Round 2:
Toggle every 2nd bulb
1  2  3  4  5  6  7  8  9 10
❌ 💡 ❌ 💡 ❌ 💡 ❌ 💡 ❌ 💡

Round 3:
Toggle every 3rd bulb
Bulbs: 3, 6, 9

Round 4:
Toggle every 4th bulb
Bulbs: 4, 8

...

Question:
After n rounds, how many bulbs remain ON?

------------------------------------------------------------

🧠 Key Insight:

A bulb is toggled once for EVERY divisor it has.

Example:

Bulb 12
Divisors:
1, 2, 3, 4, 6, 12

It gets toggled 6 times (even)
→ Ends OFF

------------------------------------------------------------

Most numbers have divisors in PAIRS.

Example:

12

1 × 12
2 × 6
3 × 4

Each pair contributes two toggles.

Even number of toggles
→ OFF

------------------------------------------------------------

Perfect squares are different.

Example:

16

1 × 16
2 × 8
4 × 4

Notice:
4 is paired with itself.

So divisors are:

1, 2, 4, 8, 16

Total = 5 divisors (odd)

Odd number of toggles
→ ON

------------------------------------------------------------

Therefore:

Only PERFECT SQUARE bulbs remain ON.

Bulbs ON for n = 10:

1
4
9

Answer = 3

------------------------------------------------------------

How many perfect squares are ≤ n ?

1²
2²
3²
...
k² ≤ n

k = √n

Answer = floor(√n)

------------------------------------------------------------

Intuitively understand it: Largest integer satisfying it

Suppose

n = 20
√20 ≈ 4.472

The largest integer not exceeding 4.472 is

4

Indeed,

1² = 1
2² = 4
3² = 9
4² = 16
5² = 25   > 20

There are exactly 4 perfect squares.

Notice

floor(√20) = floor(4.472) = 4

------------------------------------------------------------

🧾 Time Complexity:
    O(1)

🧾 Space Complexity:
    O(1)

*/

class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}