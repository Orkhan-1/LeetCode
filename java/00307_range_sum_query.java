
// Time complexity - O (log N)
// Space complexity - O (N)
public class RangeSumQuery {

    private int[] nums;
    private int[] bit;

    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        this.bit = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            updateBIT(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        updateBIT(index, diff);
    }

    public int sumRange(int left, int right) {
        return getSum(right) - getSum(left - 1);
    }

    private void updateBIT(int index, int val) {
        index++;
        while (index < bit.length) {
            bit[index] += val;
            index += index & -index;
        }
    }

    private int getSum(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }
        return sum;
    }

}
