/*



🧩 Problem

We have n bulbs, initially ON, and m number of buttons that can be pressed

Example:

n = 3

💡 💡 💡
ON ON ON

We can press 4 different buttons:

1️⃣ Toggle ALL bulbs

2️⃣ Toggle EVEN bulbs
   1 2 3 4 5 6
   ↓   ↓   ↓
   💡  💡  💡

3️⃣ Toggle ODD bulbs
   1 2 3 4 5 6
     ↓   ↓   ↓
     💡  💡  💡

4️⃣ Toggle bulbs [j = 3k + 1]: 1, 4, 7, 10...
     1 2 3 4 5 6
       ↓ ↓   ↓ ↓
       💡💡  💡💡


The question:

👉 After exactly m "presses" button presses, how many DIFFERENT configurations are possible?

------------------------------------------------------------

🔑 FIRST INTUITION

Don't think about 100 bulbs.

The buttons create repeating patterns.

For n >= 3, we only need to understand the first 3 bulbs.

Why? Because every button behaves periodically.

So the entire problem reduces to:

💡 💡 💡

Each bulb can be ON or OFF.

Therefore, there can be at most:

2 × 2 × 2 = 8 different configurations.

So:

Maximum answer = 8

------------------------------------------------------------

Example: n = 111

------------------------------------------------------------
m=0

0️⃣ presses

We don't press anything.

Only:

111

1 configuration.

------------------------------------------------------------

1️⃣ press

We can press any ONE of the 4 buttons.

From:

111

we can get:

Button 1 → 000
Button 2 → 101
Button 3 → 010
Button 4 → 011

So:

000
101
010
011

= 4 different configurations

------------------------------------------------------------

2️⃣ presses

Now we can combine buttons.

For example:

Button 1 + Button 2
111 → 000 → 010

Button 1 + Button 3
111 → 000 → 101

...

After trying all combinations, we can reach 7 different configurations.

So:

2 presses → 7

------------------------------------------------------------

3️⃣ or more presses

Now we have enough presses to reach
ALL possible configurations:

000
001
010
011
100
101
110
111

That's:

2³ = 8

More than 3 presses cannot create a 9th configuration.

So:

3+ presses → 8

------------------------------------------------------------

⚠️ BUT n can be 1 or 2

If n = 1:

Only:

ON
OFF

So maximum = 2.

If n = 2:

Possible states:

00
01
10
11

So maximum = 4.

------------------------------------------------------------

🔑 FINAL OBSERVATION

For n >= 3:

presses = 0  → 1
presses = 1  → 4
presses = 2  → 7
presses >= 3 → 8

And for small n:

n = 1 → maximum 2
n = 2 → maximum 4

*/

class Solution {
    public int flipLights(int n, int presses) {

        if (presses == 0) {
            return 1;
        }

        if (n == 1) {
            return 2;
        }

        if (n == 2) {
            return presses == 1 ? 3 : 4;
        }

        // n >= 3
        if (presses == 1) {
            return 4;
        }


        if (presses == 2) {
            return 7;
        }

        return 8;
    }
}