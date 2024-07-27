import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(4, nums, target, 0);
    }

    private List<List<Integer>> kSum(int k, int[] nums, long target, int start) {
        if (k == 2) {
            return twoSum(nums, target, start);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i <= nums.length - k; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            List<List<Integer>> tempList = kSum(k - 1, nums, target - nums[i], i + 1);
            for (List<Integer> temp : tempList) {
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> twoSumLists = new ArrayList<>();
        int l = start;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                twoSumLists.add(new ArrayList<>(Arrays.asList(nums[l], nums[r])));
                l++;
                r--;
                while (l < r && nums[l - 1] == nums[l]) {
                    l++;
                }
                while (l < r && nums[r] == nums[r + 1]) {
                    r--;
                }
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return twoSumLists;
    }

}
