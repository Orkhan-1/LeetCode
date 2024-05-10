public class CountNumberOfNiceSubarrays {

    // Time complexity - O (N)
    // Space complexity - O (1)

    public int numberOfSubarrays(int[] nums, int k) {
        int r = 0;
        int l = 0;
        int oddCount = 0;
        int result = 0;
        int tempResult = 0;

        //2,2,2,1,2,2,1,1,2,2
        while (r < nums.length) {
            if (nums[r] % 2 == 1) {
                oddCount++;
                tempResult = 0;
            }
            while (oddCount == k) {
                tempResult++;
                if (nums[l] % 2 == 1) {
                    oddCount--;
                }
                l++;
            }
            result += tempResult;
            r++;
        }
        return result;
    }
}
