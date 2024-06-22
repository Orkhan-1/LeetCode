
// Time complexity -  O (N)
// Space complexity - O (1)
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int sum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == totalSum - sum * 2) {
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }
}
