public class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> userMinutes = new HashMap<>();

        for (int[] log : logs) {
            userMinutes.computeIfAbsent(log[0], x -> new HashSet<>()).add(log[1]);
        }

        int[] result = new int[k];
        for (Set<Integer> minutes : userMinutes.values()) {
            int uam = minutes.size();
            if (uam <= k) {
                result[uam - 1]++;
            }
        }

        return result;
    }
}

// Time complexity - O(N)
// Space complexity - O (U) - unique users