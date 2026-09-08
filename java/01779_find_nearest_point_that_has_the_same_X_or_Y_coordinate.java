/*

🧩 Problem:

Nearest Valid Point

💡 Setup:

You are given a point (x, y) and an array of points.

A point is valid if it shares either:

• the same x-coordinate
• the same y-coordinate

For every valid point, calculate the
Manhattan distance:

    |x1 - x| + |y1 - y|

Return the index of the valid point
with the smallest distance.

If no valid point exists, return -1.

------------------------------------------------------------

💡 Example:

Input:

x = 3
y = 4

points = [
    [1, 2],
    [3, 1],
    [2, 4],
    [3, 4]
]

Valid points:

[3, 1] → distance = 3
[2, 4] → distance = 1
[3, 4] → distance = 0

Output:

3

------------------------------------------------------------

🧠 Key Insight:

Loop through every point and ignore
points that are not valid.

For each valid point, calculate its
Manhattan distance.

Keep track of the smallest distance
and its index.

Because we only update when:

    distance < minValue

the first point is kept when two valid
points have the same distance.

------------------------------------------------------------

🧾 Time Complexity:

O(n)

Each point is checked once.

------------------------------------------------------------

🧾 Space Complexity:

O(1)

Only two variables are used.

*/

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {

        // Minimum distance found so far
        int minValue = Integer.MAX_VALUE;

        // Index of closest valid point
        int index = -1;

        for (int i = 0; i < points.length; i++) {

            // Check if point is valid
            if (x == points[i][0] || y == points[i][1]) {

                // Calculate Manhattan distance
                int distance = Math.abs(points[i][0] - x)
                        + Math.abs(points[i][1] - y);

                // Update closest point
                if (distance < minValue) {
                    index = i;
                    minValue = distance;
                }
            }
        }

        // Return answer
        return index;
    }
}
```
