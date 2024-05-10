public class NumArray {

    private int[] nums;
    private int[] segmentTree;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.segmentTree = new int[4 * nums.length];
        buildSegmentTree(0, 0, nums.length - 1);
    }

    public int sumRange(int left, int right) {
        return query(0, 0, nums.length - 1, left, right);
    }

    private void buildSegmentTree(int currentIndex, int start, int end) {
        // nums = [1, 3, 5, 7, 9, 11]
        if (start == end) {
            segmentTree[currentIndex] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        // for index 0
        int leftChildIndex = 2 * currentIndex + 1; // 1 => 9 [0,2]
        int rightChildIndex = 2 * currentIndex + 2; // 2 => 27 [3,5]
        buildSegmentTree(leftChildIndex, start, mid);
        buildSegmentTree(rightChildIndex, mid + 1, end);
        segmentTree[currentIndex] = segmentTree[leftChildIndex] + segmentTree[rightChildIndex];
        // segmentTree [0] => segmentTree [1] + segmentTree [2]
        //       36 [0,5]  =      9           +      27
    }

    private int query(int currentIndex, int start, int end, int left, int right) {
        // [0,2]
        if (start > right || end < left) {
            return 0;
        }
        if (left <= start && right >= end) {
            return segmentTree[currentIndex];
        }
        int mid = start + (end - start) / 2; // 2
        int leftChildIndex = 2 * currentIndex + 1; // 1
        int rightChildIndex = 2 * currentIndex + 2; // 2
        int leftSum = query(leftChildIndex, start, mid, left, right); // 0, 2 => 9
        int rightSum = query(rightChildIndex, mid + 1, end, left, right); // 3,5 => 0
        return leftSum + rightSum;
    }
}
