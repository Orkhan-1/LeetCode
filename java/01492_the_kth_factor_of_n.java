class Solution {

    public int kthFactor(int n, int k) {
        int divider = 2;
        int tempCount = 1;

        while (divider <= n && tempCount < k) {
            if (n % divider == 0) {
                tempCount++;
            }
            divider++;
        }

        if (tempCount == k) {
            return divider - 1;
        }

        return -1;
    }
}

// Time complexity - O(n)
// Space complexity - O (1)