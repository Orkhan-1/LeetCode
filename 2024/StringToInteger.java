
// Time complexity - O (N)
// Space complexity - O (1)
public class StringToInteger {

    public int myAtoi(String input) {
        int sign = 1;
        int result = 0;
        int index = 0;

        while (index < input.length() && input.charAt(index) == ' ') {
            index++;
        }

        if (index < input.length() && input.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (index < input.length() && input.charAt(index) == '+') {
            index++;
        }

        while (index < input.length()) {
            int digit = input.charAt(index) - '0';
            if (digit >= 0 && digit <= 9) {
                if ((result > Integer.MAX_VALUE / 10) ||
                        (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = 10 * result + digit;
                index++;
            } else {
                break;
            }
        }
        return sign * result;
    }
}
