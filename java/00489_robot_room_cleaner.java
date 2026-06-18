/*




🧩 Problem:

Given a robot in an unknown room, clean the entire room.

The robot has only these APIs:

    move()      -> returns true if the cell in front is open
    turnLeft()  -> rotates 90° left
    turnRight() -> rotates 90° right
    clean()     -> cleans current cell

The layout of the room is unknown, and the robot's starting
position is arbitrary.

🎯 Goal:
Clean every reachable cell exactly once.

🧠 Solution:
Use DFS + Backtracking.

Since we don't know the room coordinates, assign the starting
position as (0, 0) and track visited cells using a HashSet.

Directions:

    0 -> Up
    1 -> Right
    2 -> Down
    3 -> Left

For each cell:

1️⃣ Clean current cell

2️⃣ Mark it as visited

3️⃣ Try all four directions

4️⃣ If the next cell is unvisited and `move()` succeeds,
    recursively explore it

5️⃣ Backtrack to the previous cell and restore orientation

💡 Backtracking:

After DFS into a neighbor:

    turnRight()
    turnRight()
    move()
    turnRight()
    turnRight()

This brings the robot back to its previous position while
facing the original direction.

🧾 Time Complexity:
    O(N)

where N = number of reachable cells.

🧾 Space Complexity:
    O(N)

for the visited set and recursion stack.

This is the robot's control interface.
interface Robot {
    public boolean move();
    public void turnLeft();
    public void turnRight();
    public void clean();



 */

class Solution {

    private Set<String> visited = new HashSet<>();

    // Up, Right, Down, Left
    private int[][] dirs = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0);
    }

    private void dfs(Robot robot, int x, int y, int dir) {

        visited.add(x + "," + y);
        robot.clean();

        for (int i = 0; i < 4; i++) {

            int newDir = (dir + i) % 4;
            int nx = x + dirs[newDir][0];
            int ny = y + dirs[newDir][1];

            if (!visited.contains(nx + "," + ny) && robot.move()) {
                dfs(robot, nx, ny, newDir);

                // Backtrack
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }

            // Rotate to the next direction
            robot.turnRight();
        }
    }
}