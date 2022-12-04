public class MaximumSwap {

    /*
     * Greedy approach:
     * 1.For each number we find its last position in the array e.g. in 6884 8 appears twice.
     * Applying greedy approach we want to swap last apprearing digit 8864 not 8684
     * 2. We go over the array one more time and find first element and swap it with the digit that is
     * more than current digit and is max.
     *
     * */

    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] digitToIndex = new int[10];
        for (int i = 0; i < digits.length; i++) {
            digitToIndex[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (digitToIndex[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[digitToIndex[k]];
                    digits[digitToIndex[k]] = tmp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }
}
