import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    public int minDifference(int[] nums) {
        int size = nums.length;

        if (size < 4) {
            return 0;
        }

        Arrays.sort(nums);

        int optionOne = nums[size - 4] - nums[0];
        int optionTwo = nums[size - 3] - nums[1];
        int optionThree = nums[size - 2] - nums[2];
        int optionFour = nums[size - 1] - nums[3];

        return Math.min(Math.min(optionOne, optionTwo), Math.min(optionThree, optionFour));
    }
}
