import java.util.*;

public class MinimumNumberOfFrogsCroaking {

    public int minNumberOfFrogs(String croakOfFrogs) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('c', 0);
        map.put('r', 0);
        map.put('o', 0);
        map.put('a', 0);
        map.put('k', 0);

        List<Character> list = new LinkedList<>();
        list.add('c');
        list.add('r');
        list.add('o');
        list.add('a');
        list.add('k');

        for (int i = croakOfFrogs.length() - 1; i >= 0; i--) {
            stack.push(croakOfFrogs.charAt(i));
        }

        int result = 0;
        int pointer = 0;
        while (!stack.empty()) {
            Character c = stack.pop();
            Integer value = map.get(c);

            if (value < 0) {
                return -1;
            }
            map.put(c, value + 1);

            if ((c != list.get(pointer) && c == 'c')) {
                result++;
                pointer = 0;
            }

            if (c == 'k' && !stack.empty() && stack.peek() != 'c') {
                pointer = 0;
            } else if (c == 'k' && stack.empty()) {
                result++;
                pointer = 0;
            }
            pointer++;
            if (pointer == 5) {
                pointer = 0;
            }
        }

        for (Integer value : map.values()) {
            if (value != croakOfFrogs.length() / 5) {
                return -1;
            }
        }
        return result;
    }


}
