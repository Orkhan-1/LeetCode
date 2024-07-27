// Time complexity - O (N)
// Space complexity - O (1)
public class CountElementsWithStrictlySmallerAndGreaterElements {

    public int countElements(int[] nums) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int num : nums) {
            if (num > min && num < max) {
                result++;
            }
        }

        return result;
    }
}
