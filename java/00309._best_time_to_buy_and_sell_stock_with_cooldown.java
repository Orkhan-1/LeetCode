//        Java
// Time complexity - O(n×2×2)=O(4n)=O(n)
// Space complexity - O (n)

public class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> memo = new HashMap<>();
        return generateTree(prices, false, false, 0, memo);
    }

    private int generateTree(int[] prices, boolean bought, boolean sold, int day, Map<String, Integer> memo) {
        if (day >= prices.length) {
            return 0;
        }

        String key = day + "_" + bought + "_" + sold;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int maxProfit = 0;

        if (bought) {
            int sellProfit = generateTree(prices, false, true, day + 1, memo) + prices[day];
            int holdProfit = generateTree(prices, true, false, day + 1, memo);
            maxProfit = Math.max(sellProfit, holdProfit);
        } else {
            if (sold) {
                maxProfit = generateTree(prices, false, false, day + 1, memo);
            } else {
                int buyProfit = generateTree(prices, true, false, day + 1, memo) - prices[day];
                int skipProfit = generateTree(prices, false, false, day + 1, memo);
                maxProfit = Math.max(buyProfit, skipProfit);
            }
        }

        memo.put(key, maxProfit);
        return maxProfit;
    }
}