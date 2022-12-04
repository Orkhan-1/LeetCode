public class NthDigit {

    /*
     * 1.Define layer
     * 2.Define digit
     * 3.Define position
     *
     * 1 Layer - 9 * 1
     * 2 Layer - (99-9)=90 * 2
     * 3 Layer - (999-99)=900 * 3
     * 4 Layer - (9999-999)=9000 * 4
     * ......
     * */

    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        // 1.Define layer
        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        // 2.Define digit
        start += (n - 1) / len;
        String s = Integer.toString(start);

        // 3.Define position
        char result = s.charAt((n - 1) % len);
        return result - '0';
    }

}
