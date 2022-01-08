import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        return bt(0, num, new ArrayList<>());
    }

    private boolean bt(int curr, String num, List<String> result) {
        if (curr == num.length() && result.size() >= 3) {
            return true;
        }
        for (int i = curr; i <= num.length() - 1; i++) {
            String sum = num.substring(curr, i + 1);
            if (result.size() <= 1 || isEqual(sum, result)) {
                if (sum.length() > 1 && sum.charAt(0) == '0') {
                    return false;
                }
                result.add(sum);
                if (bt(i + 1, num, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    private boolean isEqual(String thirdNumber, List<String> result) {
        long first = Long.parseLong(result.get(result.size() - 1));
        long second = Long.parseLong(result.get(result.size() - 2));
        return thirdNumber.equals(String.valueOf(first + second));
    }
}
