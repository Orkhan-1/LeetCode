public class MinimumNumberOfFrogsCroaking {

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int[5];
        int maxNumberOfFrogs = 0;


        for (char c : croakOfFrogs.toCharArray()) {

            // 1. Iterate and count
            if (c == 'c') {
                count[0]++;
            } else if (c == 'r') {
                count[1]++;
            } else if (c == 'o') {
                count[2]++;
            } else if (c == 'a') {
                count[3]++;
            } else if (c == 'k') {
                count[4]++;
            } else {
                return -1;
            }

            // 2.Check order
            if (count[1] > count[0] || count[2] > count[1] || count[3] > count[2] || count[4] > count[3]) {
                return -1;
            }

            // 3. if there is 'k', decrement
            if (c == 'k') {
                for (int i = 0; i < 5; i++) {
                    count[i]--;
                }
            }
            // 4. Take max number of froags at the time
            maxNumberOfFrogs = Math.max(maxNumberOfFrogs, count[0]);
        }

        for (int i = 0; i < 5; i++) {
            if (count[i] != 0) {
                return -1;
            }
        }
        return maxNumberOfFrogs;
    }
}
