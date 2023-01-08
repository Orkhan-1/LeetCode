import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];

            if ("+".equals(cur) || "-".equals(cur) || "*".equals(cur) || "/".equals(cur)) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(calculate(first, second, cur));
            } else {
                stack.push(Integer.valueOf(cur));
            }
        }
        return stack.pop();
    }

    private int calculate(int f, int s, String opr) {
        if ("+".equals(opr)) {
            return s + f;
        }
        if ("-".equals(opr)) {
            return s - f;
        }
        if ("/".equals(opr)) {
            return s / f;
        }
        return s * f;
    }

}
