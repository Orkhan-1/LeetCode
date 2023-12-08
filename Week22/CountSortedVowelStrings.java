// Time complexity -  O(5^N)
// Space complexity - O (N) - depth of the recursion
public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {
        int[] result = {0};
        bt(0, n, result);
        return result[0];
    }

    private void bt(int l, int n, int[] result) {
        if (n == 0) {
            result[0]++;
            return;
        }

        for (int i = l; i < 5; i++) {
            bt(i, n - 1, result);
        }

    }
}
