import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            result = Math.max(result,(nums[i] + nums[j]));
            i++;
            j--;
        }
        return result;
    }
}
