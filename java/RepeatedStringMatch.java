
// Time complexity - O (N)
// Space complexity - O (N)
public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        int count = 1;
        StringBuilder sb = new StringBuilder(A);

        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }

        if (sb.toString().contains(B)) {
            return count;
        }

        if (sb.append(A).toString().contains(B)) {
            return count + 1;
        }

        return -1;
    }
}
