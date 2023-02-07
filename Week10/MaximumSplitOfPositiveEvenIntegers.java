import java.util.ArrayList;
import java.util.List;

public class MaximumSplitOfPositiveEvenIntegers {

    public static List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) {
            return new ArrayList<>();
        }
        List<Long> result = new ArrayList<>();
        long temp = 2;
        while (temp <= finalSum) {
            result.add(temp);
            finalSum -= temp;
            temp += 2;
        }
        long lastElement = result.get(result.size() - 1) + finalSum;
        result.remove(result.size() - 1);
        result.add(lastElement);
        return result;
    }
}
