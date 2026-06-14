/**
 * 🧩 Problem:
 * You have two jugs with capacities:
 *      x liters
 *      y liters
 *
 * You can perform these operations:
 *    1️⃣ Fill either jug completely
 *    2️⃣ Empty either jug
 *    3️⃣ Pour water from one jug into the other until:
 *          - the source becomes empty, or
 *          - the destination becomes full
 *
 * 🎯 Goal:
 * Determine whether it is possible to measure exactly
 * "target" liters.
 *
 * ---------------------------------------------------
 *
 * 🧠 Key Observation:
 *
 * If target is larger than the total capacity:
 *
 *      target > x + y
 *
 * then it is impossible.
 *
 * Example:
 *
 *      x = 3
 *      y = 5
 *      target = 9
 *
 * Maximum water we can ever have = 8
 *
 * Answer = false
 *
 * ---------------------------------------------------
 *
 * 🧠 Mathematical Idea (Bézout's Theorem):
 *
 * By repeatedly filling, emptying, and pouring,
 * we can only create amounts that are multiples
 * of gcd(x, y).
 *
 * Therefore:
 *
 *      target is possible
 *
 * iff
 *
 *      target % gcd(x, y) == 0
 *
 * and
 *
 *      target <= x + y
 *
 * ---------------------------------------------------
 *
 * 💡 Example 1:
 *
 *      x = 3
 *      y = 5
 *      target = 4
 *
 * gcd(3,5) = 1
 *
 * 4 % 1 = 0
 *
 * x + y = 8 >= 4
 *
 * Answer = true
 *
 * ---------------------------------------------------
 *
 * 💡 Example 2:
 *
 *      x = 2
 *      y = 6
 *      target = 5
 *
 * gcd(2,6) = 2
 *
 * 5 % 2 = 1
 *
 * Answer = false
 *
 * ---------------------------------------------------
 *
 * 🧠 Algorithm:
 *
 * 1️⃣ If target == 0
 *        return true
 *
 * 2️⃣ If target > x + y
 *        return false
 *
 * 3️⃣ Compute gcd(x, y)
 *
 * 4️⃣ Return:
 *
 *        target % gcd == 0
 *
 * ---------------------------------------------------
 *
 * 🧾 Time Complexity:
 *      O(log(min(x, y)))
 *
 * 🧾 Space Complexity:
 *      O(1)
 */

class Solution {

    public boolean canMeasureWater(int x, int y, int target) {

        if (target == 0)
            return true;

        if (target > x + y)
            return false;

        return target % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}