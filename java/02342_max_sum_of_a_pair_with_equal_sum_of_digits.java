/*

Example:
Input:
nums = [18, 43, 36, 13, 7]

Step-by-step:
Sum of digits:
18 → 1+8 = 9
43 → 4+3 = 7
36 → 3+6 = 9
13 → 1+3 = 4
7  → 7

For sum=7 → (43, 7) = 50
For sum=9 → (18, 36) = 54

Maximum = 54

=========================================================================
=========================================================================

Example 2:
Input:
nums = [10, 12, 19, 14]

Digit sums:
10 → 1
12 → 3
19 → 10
14 → 5

Output: -1

*/

class Solution {
    public int maximumSum(int[] nums) {

        Map <Integer, Integer> pairs = new HashMap <> ();

        int maxValue = -1;

        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums [i];

            int currentSum = 0;
            while (currentNumber>0) {
                currentSum += currentNumber % 10;
                currentNumber = currentNumber/10;
            }

            if (pairs.containsKey (currentSum)) {
                int currentMax = pairs.get (currentSum) + nums [i]; // [18, 43, 36, 13, 7, 54]
                // 9 - 36
                maxValue = Math.max (maxValue, currentMax);
                if (nums [i]>pairs.get(currentSum)) {
                    pairs.put (currentSum, nums [i]);
                }
            } else {
                pairs.put (currentSum, nums [i]);
            }

        }
        return maxValue;
    }
}