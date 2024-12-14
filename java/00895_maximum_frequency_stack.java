//       Java
// Time complexity - push, pop, peek: O (1)
// Space complexity - O (N)

// ["push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
// [ [5],    [7],    [5],    [7],    [4],    [5]],    5      7      5      4

// 5 - 3
// 7 - 2
// 4 - 1

class FreqStack {
    // Maintains frequencies of elements
    private Map<Integer, Integer> freqMap;
    // Maintains stacks of elements by frequency
    private Map<Integer, Stack<Integer>> groupMap;
    private int maxFreq = 0;

    public FreqStack() {
        freqMap = new HashMap<>();
        groupMap = new HashMap<>();
    }

    public void push(int x) {
        int freq = freqMap.getOrDefault(x, 0) + 1;
        freqMap.put(x, freq);

        maxFreq = Math.max(maxFreq, freq);

        if (!groupMap.containsKey(freq)) {
            groupMap.put(freq, new Stack<>());
        }
        groupMap.get(freq).push(x);
    }

    public int pop() {
        if (!groupMap.containsKey(maxFreq)) {
            return -1;
        }

        int val = groupMap.get(maxFreq).pop();
        freqMap.put(val, freqMap.get(val) - 1);

        if (groupMap.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }

    public int peek() {
        return groupMap.get(maxFreq).peek();
    }
}
