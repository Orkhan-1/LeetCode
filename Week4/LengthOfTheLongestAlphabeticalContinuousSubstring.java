public class LengthOfTheLongestAlphabeticalContinuousSubstring {

    public int longestContinuousSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int tempMax = 1;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = (int) chars[i];
            if (current == prev + 1) {
                tempMax++;
            } else {
                max = Math.max(max, tempMax);
                tempMax = 1;
            }
            prev = current;
        }
        max = Math.max(max, tempMax);
        return max;
    }

}
