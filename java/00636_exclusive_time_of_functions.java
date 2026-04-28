class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<String> stack = new Stack<>();
        int[] result = new int[n];

        stack.push(logs.get(0));
        int i = 1;

        while (i < logs.size()) {
            if (stack.isEmpty()) {
                stack.push(logs.get(i));
                i++;
                continue;
            }

            String[] currentFunction = stack.peek().split(":");
            String[] newFunction = logs.get(i).split(":");

            if (newFunction[1].equals("end")) {
                int executionTime = Integer.parseInt(newFunction[2]) -
                        Integer.parseInt(currentFunction[2]) + 1;
                result[Integer.parseInt(newFunction[0])] += executionTime;
                stack.pop();

                if (!stack.isEmpty()) {
                    String[] previousFunction = stack.peek().split(":");
                    int newValue = Integer.parseInt(newFunction[2]) + 1;
                    String updatedValue = previousFunction[0] + ":" +
                            previousFunction[1] + ":" + newValue;
                    stack.pop();
                    stack.push(updatedValue);
                }
            } else {
                int elapsed = Integer.parseInt(newFunction[2]) -
                        Integer.parseInt(currentFunction[2]);
                result[Integer.parseInt(currentFunction[0])] += elapsed;

                String updatedCurrent = currentFunction[0] + ":" +
                        currentFunction[1] + ":" + newFunction[2];
                stack.pop();
                stack.push(updatedCurrent);
                stack.push(logs.get(i));
            }

            i++;
        }

        return result;
    }
}