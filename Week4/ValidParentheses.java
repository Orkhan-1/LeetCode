import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack <> ();
        for (int i=0; i<s.length(); i++) {
            char p = s.charAt(i);
            if (p=='('||p=='{'||p=='[') {
                stack.push(p);
            } else if (p==')'&&!stack.empty()&&stack.peek()=='(') {
                stack.pop();
            } else if (p=='}'&&!stack.empty()&&stack.peek()=='{') {
                stack.pop();
            } else if (p==']'&&!stack.empty()&&stack.peek()=='[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
