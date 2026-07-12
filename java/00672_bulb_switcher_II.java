/*

🧩 Problem:

Bulb Switcher II (LeetCode 672)

💡 Setup:

n bulbs, all initially ON.
4 buttons, and you press buttons m times total (any combo, repeats allowed):

Button 1 → flip ALL bulbs
Button 2 → flip EVEN-indexed bulbs      (2, 4, 6, ...)
Button 3 → flip ODD-indexed bulbs       (1, 3, 5, ...)
Button 4 → flip bulbs at indices 3k+1   (1, 4, 7, ...)

Question:
After exactly m presses (any buttons, any order), how many
DISTINCT final bulb configurations are possible?

------------------------------------------------------------

💡 Example (n = 3, m = 1):

Start:
1  2  3
💡 💡 💡

Press button 1 (flip all):
❌ ❌ ❌

Press button 2 (flip even):
💡 ❌ 💡

Press button 3 (flip odd):
❌ 💡 ❌

Press button 4 (flip 3k+1 → index 1):
❌ 💡 💡

→ 4 distinct results after 1 press.

------------------------------------------------------------

🧠 Key Insight #1:

Only the state of the FIRST 3 bulbs actually matters.

Why? Because each button's effect on bulb i only depends on
i mod 2 or i mod 3. So bulb 4 always behaves exactly like bulb 1,
bulb 5 like bulb 2, bulb 6 like bulb 3, and so on.

The pattern repeats every 3 bulbs.

→ So we only need to simulate for n = min(n, 3).

------------------------------------------------------------

🧠 Key Insight #2:

Pressing the SAME button twice cancels itself out
(every button is its own inverse).

So what actually matters is not "which sequence of m presses",
but "which buttons were pressed an ODD number of times".

That means the number of distinct outcomes is bounded — it can't
just keep growing with m. It saturates quickly.

------------------------------------------------------------

🧠 Key Insight #3 — enumerate the small cases:

n = 0        → always 1 state (no bulbs to flip)

n = 1        → only buttons 1 & 3 touch bulb 1
                → 2 possible states (once m ≥ 1)

n = 2:
    m = 1    → 3 distinct states reachable
    m ≥ 2    → 4 distinct states reachable (all combos possible)

n ≥ 3:
    m = 1    → 4 distinct states (one per button pressed alone)
    m = 2    → 7 distinct states (pairs of button-presses combine,
                one repeat overlaps with m=0 case handled separately)
    m ≥ 3    → 8 distinct states (max possible = 2³ patterns for
                3 bulbs, fully saturated)

------------------------------------------------------------

Intuitively understand it: why it SATURATES

There are only 3 bulbs that matter → only 2³ = 8 possible
on/off patterns total. No matter how many more times you press
buttons, you can never produce more than 8 distinct configurations.

That's why m ≥ 3 always gives the same answer (8) for n ≥ 3 —
you've already unlocked every reachable pattern.

------------------------------------------------------------

🧾 Time Complexity:
    O(1)

🧾 Space Complexity:
    O(1)

*/

class Solution {
    public int flipLights(int n, int m) {
        n = Math.min(n, 3);
        if (m == 0) {
            return 1;
        }

        if (n == 1) {
            return 2;
        }

        if (n == 2) {
            return m == 1 ? 3 : 4;
        }

        if (m == 1) {
            return 4;
        }
        if (m == 2) {
            return 7;
        }
        return 8;
    }
}