import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        } else if (n < 1) {
            return false;
        }
        Set<Integer> dp = new HashSet<>();
        int sum = 0;
        while (n != 1) {
            while (n != 0) {
                int tempNumber = n % 10;
                int square = tempNumber * tempNumber;
                n = n / 10;
                sum += square;
            }
            if (dp.contains(sum)) {
                return false;
            }
            dp.add(sum);
            n = sum;
            sum = 0;
        }
        return true;
    }

}
