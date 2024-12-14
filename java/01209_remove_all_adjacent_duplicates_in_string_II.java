//       Java
// Time complexity - O (N)
// Space complexity - O (1)

// example: s = "deeedbbcccbdaa", k = 3
//          s = "deeedbbcccbdaa"

public class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().character == c) {
                stack.peek().count++;
                if (stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                stack.push(new Pair(c, 1));
            }
        }

        StringBuilder result = new StringBuilder();
        for (Pair p : stack) {
            result.append(String.valueOf(p.character).repeat(p.count));
        }
        return result.toString();
    }

    private static class Pair {
        char character;
        int count;

        Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
}
