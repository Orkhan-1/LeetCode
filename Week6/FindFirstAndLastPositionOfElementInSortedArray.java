public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int f = getFirst(nums, 0, nums.length - 1, target);
        int e = getLast(nums, 0, nums.length - 1, target);
        return new int[]{f, e};
    }

    private int getFirst(int[] nums, int left, int right, int target) {
        int result = -1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private int getLast(int[] nums, int left, int right, int target) {
        int result = -1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

}
