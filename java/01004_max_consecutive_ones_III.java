/*

Given a binary array nums and an integer k, you can flip at most k zeros to ones.
Return the maximum number of consecutive 1s in the array after flipping. 💡🎯

Example: 📝
nums = [1,1,0,0,1,1,1,0,1], k = 2

Sliding Window Approach 🪟👆:
We maintain a window [left, right] that contains at most k zeros.
- Expand right pointer ➡️➕
- If zeros exceed k, shrink window from left ⬅️➖
- Keep track of max window size 📏📈

Example (k=2):
Index:    0   1   2   3   4   5   6   7   8
Nums:    [1] [1] [0] [0] [1] [1] [1] [0] [1]
         🟦 🟦 ⚫ ⚫ 🟦 🟦 🟦 ⚫ 🟦

Window -> [0.........6] after flipping two 0s 🔄🔄
         🟦 🟦 🟦 🟦 🟦 🟦 🟦 ⚫ 🟦
         (flipped) 🔄    (flipped) 🔄

Max consecutive 1s = 7 🏆🌟

Algorithm Complexity: ⚙️
Time: O(n) - Single pass through array ⚡🚀
Space: O(1) - Constant extra space 💾
*/

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, zeros = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;

            while (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}