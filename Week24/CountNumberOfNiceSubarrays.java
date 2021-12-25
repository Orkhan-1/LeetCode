public class CountNumberOfNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int count = 0;
        int result = 0;
        while (r < nums.length) {
            if (nums[r] % 2 == 1) {
                count++;
            }
            if (count < k) {
                r++;
                continue;
            }
            int start = l;
            while (nums[l] % 2 == 0) {
                result++;
                l++;
            }
            result++;
            int window = l - start + 1;
            while (r + 1 < nums.length && nums[r + 1] % 2 == 0) {
                result += window;
                r++;
            }
            r++;
            l++;
        }
        return result;
    }
}
