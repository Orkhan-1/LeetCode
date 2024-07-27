import java.util.Stack;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (st.size() >= 1) {
                    sb.append(s.charAt(i));
                }
                st.push(s.charAt(i));
            } else {
                if (st.size() > 1) {
                    sb.append(s.charAt(i));
                }
                st.pop();
            }
        }
        return sb.toString();
    }
}
