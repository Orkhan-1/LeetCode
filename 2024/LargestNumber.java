import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        if (str[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String cur : str) {
            result.append(cur);
        }

        return result.toString();
    }
}
