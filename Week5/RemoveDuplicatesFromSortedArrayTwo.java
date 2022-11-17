public class RemoveDuplicatesFromSortedArrayTwo {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int l = 2;
        int r = 2;
        while (r < nums.length) {
            if (nums[l - 2] == nums[r]) {
                r++;
            } else {
                nums[l++] = nums[r++];
            }
        }
        return l;
    }
}
