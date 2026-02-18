/**
 * 🧩 Problem:
 * Design a stack that supports:
 *    - push(x): Push element x onto stack
 *    - pop(): Remove and return top element
 *    - top(): Return top element
 *    - peekMax(): Return max element
 *    - popMax(): Remove and return max element
 *
 * 🎯 Goal:
 *    - All operations should work efficiently
 *
 * 🧠 Idea:
 *    We’ll use two stacks:
 *      1️⃣ mainStack → normal stack
 *      2️⃣ maxStack → keeps track of current max
 *
 * 💡 Example:
 *   push(5) → 🧱 [5]          max=[5]
 *   push(1) → 🧱 [5,1]        max=[5,5]
 *   push(5) → 🧱 [5,1,5]      max=[5,5,5]
 *   top()    → 5
 *   popMax() → remove top-most 5 (max)
 *              🧱 [5,1]        max=[5,5]
 *   top()    → 1
 *
 * ⚙️ popMax Logic:
 *    - Pop elements into a buffer until top == max
 *    - Remove that max
 *    - Push back everything from buffer
 *
 * 🧾 Time Complexity:
 *    - push(), pop(), top(), peekMax(): O(1)
 *    - popMax(): O(n) (worst case)
 */

import java.util.*;

class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> buffer = new Stack<>();

        while (stack.peek() != max) {
            buffer.push(stack.pop());
            maxStack.pop();
        }

        stack.pop();
        maxStack.pop();

        while (!buffer.isEmpty()) {
            this.push(buffer.pop());
        }

        return max;
    }
}
