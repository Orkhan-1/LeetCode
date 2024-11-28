#        Python
# Time complexity - O(n×2×2)=O(4n)=O(n)
# Space complexity - O (n)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        memo = {}
        return self.generate_tree(prices, False, False, 0, memo)

    def generate_tree(self, prices: List[int], bought: bool, sold: bool, day: int, memo: Dict[str, int]) -> int:
        if day >= len(prices):
            return 0

        key = f"{day}_{bought}_{sold}"
        if key in memo:
            return memo[key]

        max_profit = 0

        if bought:
            sell_profit = self.generate_tree(prices, False, True, day + 1, memo) + prices[day]
            hold_profit = self.generate_tree(prices, True, False, day + 1, memo)
            max_profit = max(sell_profit, hold_profit)
        else:
            if sold:
                max_profit = self.generate_tree(prices, False, False, day + 1, memo)
            else:
                buy_profit = self.generate_tree(prices, True, False, day + 1, memo) - prices[day]
                skip_profit = self.generate_tree(prices, False, False, day + 1, memo)
                max_profit = max(buy_profit, skip_profit)

        memo[key] = max_profit
        return max_profit
