class Solution {
    public int countElements(int[] nums, int k) {

        if (k==0) {
            return nums.length;
        }

        Arrays.sort (nums);
        int j = nums.length - k;

        while (j>0) {
            if (nums [j-1] < nums [j]) {
                break;
            }
            j--;
        }

        return j;
    }
}