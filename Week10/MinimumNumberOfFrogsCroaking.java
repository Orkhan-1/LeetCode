public class MinimumNumberOfFrogsCroaking {

    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() == 0) {
            return 0;
        }

        int[] freq = new int[5];
        int result = 0;

        for (char c : croakOfFrogs.toCharArray()) {
            if (c == 'c') {
                freq[0]++;
                result++;
            } else if (c == 'r') {
                freq[1]++;
                if (isValidSequence(1, freq)) {
                    return -1;
                }
            } else if (c == 'o') {
                freq[2]++;
                if (isValidSequence(2, freq)) {
                    return -1;
                }
            } else if (c == 'a') {
                freq[3]++;
                if (isValidSequence(3, freq)) {
                    return -1;
                }
            } else if (c == 'k') {
                freq[4]++;
                if (isValidSequence(4, freq)) {
                    return -1;
                }
            }
        }

        if (freq[0] * 5 != croakOfFrogs.length()) {
            return -1;
        }

        return result;
    }

    private boolean isValidSequence(int position, int[] freq) {
        return freq[position - 1] < freq[position];
    }


}
