import java.util.Stack;

// Time complexity - O (N)
// Space complexity - O (N)
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();

        for (char ch : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop()); // a c => ca
        }

        return result.toString();
    }
}
