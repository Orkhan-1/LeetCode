import java.util.List;
import java.util.Stack;

// Time complexity -  O(N + E) N - rooms, E - keys
// Space complexity - O (N)
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();

            for (int nextRoom : rooms.get(currentRoom)) {
                if (!visited[nextRoom]) {
                    stack.push(nextRoom);
                    visited[nextRoom] = true;
                }
            }
        }

        for (boolean visitedRoom : visited) {
            if (!visitedRoom) {
                return false;
            }
        }
        return true;
    }
}
