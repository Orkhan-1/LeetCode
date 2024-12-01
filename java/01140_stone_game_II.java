import java.util.HashMap;
import java.util.Map;

class Solution {

    public int stoneGameII(int[] piles) {
        return getMaxScore(true, 1, 0, piles, new HashMap<>());
    }

    private int getMaxScore(boolean turn, int m, int index, int[] piles, Map<String, Integer> memo) {
        if (index >= piles.length) {
            return 0;
        }

        String key = index + "_" + m + "_" + turn;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int maxScore = turn ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int tempScore = 0;

        for (int x = 1; x <= 2 * m; x++) {
            if (index + x > piles.length) break;

            tempScore += piles[index + x - 1];

            if (turn) {
                maxScore = Math.max(maxScore, tempScore + getMaxScore(false, Math.max(m, x), index + x, piles, memo));
            } else {
                maxScore = Math.min(maxScore, getMaxScore(true, Math.max(m, x), index + x, piles, memo));
            }
        }

        memo.put(key, maxScore);
        return maxScore;
    }
}
