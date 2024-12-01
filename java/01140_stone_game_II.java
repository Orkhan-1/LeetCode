import java.util.HashMap;
import java.util.Map;

class Solution {

    public int stoneGameII(int[] piles) {
        return getMaxScore(true, 1, 1, 0, 0, piles, new HashMap<>());
    }

    private int getMaxScore(boolean turn, int m, int x, int index, int maxScore, int[] piles, Map<String, Integer> memo) {
        if (memo.containsKey(index + "_" + x)) {
            return memo.get(index + "_" + x);
        }
        m = Math.max(m, x);
        int tempScore = 0;
        if (turn) {
            for (int i = index; i < index + 2 * m && i < piles.length; i++) {
                tempScore += piles[i];
                int currentScore = tempScore + getMaxScore(false, m, i - index + 1, index + 1, maxScore, piles, memo);
                maxScore = Math.max(maxScore, currentScore);
            }
        } else {
            for (int i = index; i < index + 2 * m && i < piles.length; i++) {
                int currentScore = getMaxScore(false, m, i - index + 1, index + 1, maxScore, piles, memo);
                maxScore = Math.max(maxScore, currentScore);
            }
        }
        memo.put(index + "_" + x, maxScore);
        return maxScore;
    }
}
