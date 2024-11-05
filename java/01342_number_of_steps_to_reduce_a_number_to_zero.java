/*
n=14
if even /2
if odd -1

14 => 1110
if even /2 [Check the least significant bit (0)  => right shift 1110 > 0111]
if odd -1  [Check the least significant bit (1)  => flip 0111 > 0110]


Time complexity - O(log n)
Space complexity - O(1)

*/

class Solution {

    public int numberOfSteps(int n) {
        int steps = 0;
        while (n != 0) {
            if ((n & 1) == 0) {
                n >>= 1;
            } else {
                n = n & ~1;
            }
            steps++;
        }
        return steps;
    }

}