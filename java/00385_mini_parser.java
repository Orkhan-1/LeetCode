/*



🧩 Problem:

You are given a string representing a nested list of integers.

Examples:

"324"
"[123,[456,[789]]]"
"[-1,[2,-3],4]"

Return the corresponding NestedInteger object.

NestedInteger supports:
• storing a single integer
• storing a nested list of NestedInteger objects

------------------------------------------------------------

💡 Example:

Input:

"[123,[456,[789]]]"

Processing:

[
    123,
    [
        456,
        [
            789
        ]
    ]
]

------------------------------------------------------------

🧾 Time Complexity:

O(n)

Each character is processed exactly once.

------------------------------------------------------------

🧾 Space Complexity:

O(d)

d = maximum nesting depth (stack stores one NestedInteger per nesting level)

*/

public interface NestedInteger {

    public NestedInteger();

    public NestedInteger(int value); //"[123,[456,[789]]]"

    public void add(NestedInteger ni);



    public boolean isInteger();

    public Integer getInteger();

    public void setInteger(int value);

    public List<NestedInteger> getList();
}

class Solution {
    public NestedInteger deserialize(String s) {

        // Single integer
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s)); // "324"
        }

        Stack<NestedInteger> stack = new Stack<>();
        int i = 0;

        while (i < s.length()) {

            char ch = s.charAt(i);

            if (ch == '[') {

                stack.push(new NestedInteger());
                i++;

            } else if (ch == ']') { // "[123,[456,[789]]]"

                NestedInteger curr = stack.pop();

                if (stack.isEmpty()) {
                    return curr;
                }

                stack.peek().add(curr);
                i++;

            } else if (ch == ',') {

                i++;

            } else {

                int sign = 1;

                if (ch == '-') { //"[123,[-456,[789]]]"
                    sign = -1;
                    i++;
                }

                int num = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                stack.peek().add(new NestedInteger(sign * num));
            }
        }

        return new NestedInteger();
    }
}

