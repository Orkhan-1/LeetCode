import java.util.ArrayList;
import java.util.List;

// Time complexity -  O(2^N)
// Space complexity - O (N) - depth of recusion stack || max size of the list
public class SplitArrayIntoFibonacciSequence {

    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        bt(num, result, 0);
        return result;
    }

    private boolean bt(String num, List<Integer> result, int index) {

        if (index == num.length() && result.size() >= 3) {
            return true;
        }

        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i > index) {
                break;
            }


            long number = Long.parseLong(num.substring(index, i + 1));

            if (number > Integer.MAX_VALUE) {
                break;
            }

            int size = result.size();

            if (size >= 2 && number > result.get(size - 1) + result.get(size - 2)) {
                break;
            }

            if (size < 2 || number == result.get(size - 1) + result.get(size - 2)) {
                result.add((int) number);

                if (bt(num, result, i + 1)) {
                    return true;
                }

                result.remove(result.size() - 1);
            }
        }
        return false;
    }
}