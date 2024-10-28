// Time complexity - O (n)
// Space complexity - O (n)
public class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);

        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + dp[deque.peekFirst()];

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return dp[n - 1];
    }
}
