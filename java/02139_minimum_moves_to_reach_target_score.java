// Time complexity - O(log(target))
// Space complexity - O (1)

class Solution {
    public int minMoves(int target, int maxDoubles) {
        int steps = 0;

        if (maxDoubles == 0) {
            return target - 1;
        }

        while (target > 0 && maxDoubles > 0) {
            if (target % 2 == 0) {
                target /= 2;
                maxDoubles--;
            } else {
                target--;
            }
            steps++;
        }

        return steps + target - 1;
    }
}