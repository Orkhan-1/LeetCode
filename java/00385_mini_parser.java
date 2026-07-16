/*

🧩 Problem:

Mini Parser (LeetCode 385)

💡 Setup:

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

Output:

NestedInteger representing the same structure.

------------------------------------------------------------

🧠 Key Insight #1:

Whenever we see '[',

a brand new list begins.

We create a new NestedInteger list and push it onto the stack.

The top of the stack always represents
the current list we are filling.

------------------------------------------------------------

🧠 Key Insight #2:

Whenever we encounter a number,

parse the complete integer
(handle negative numbers too),

then add it to the list on top of the stack.

Example:

"[12,-34]"

Parse:

12

then

-34

------------------------------------------------------------

🧠 Key Insight #3:

Whenever we see ']',

the current list is complete.

Pop it from the stack.

If another list still exists,
add this completed list into its parent.

If the stack becomes empty,

this completed list is the final answer.

------------------------------------------------------------

🧠 Stack Flow:

Input:

"[123,[456]]"

'['
Stack:
[
  []
]

123

[
  [123]
]

'['

[
  [123],
  []
]

456

[
  [123],
  [456]
]

']'

Pop [456]
Add to parent

[
  [123,[456]]
]

']'

Pop

Stack empty

Return root

------------------------------------------------------------

🧾 Time Complexity:

O(n)

Each character is processed exactly once.

------------------------------------------------------------

🧾 Space Complexity:

O(d)

d = maximum nesting depth
(stack stores one NestedInteger per nesting level)

*/

class Solution {
    public NestedInteger deserialize(String s) {

        // Single integer
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        int i = 0;

        while (i < s.length()) {

            char ch = s.charAt(i);

            if (ch == '[') {

                stack.push(new NestedInteger());
                i++;

            } else if (ch == ']') {

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

                if (ch == '-') {
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