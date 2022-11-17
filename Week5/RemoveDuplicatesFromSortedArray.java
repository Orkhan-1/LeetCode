public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = 1;
        while (r < nums.length) {
            if (nums[l] == nums[r]) {
                r++;
            } else {
                nums[++l] = nums[r++];
            }
        }
        return l + 1;
    }

}
