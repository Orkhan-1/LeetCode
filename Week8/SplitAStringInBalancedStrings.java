public class SplitAStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int r = 0;
        int l = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                r++;
            } else {
                l++;
            }
            if (r != 0 && l != 0 && l == r) {
                result++;
                r = 0;
                l = 0;
            }
        }
        return result;
    }
}
