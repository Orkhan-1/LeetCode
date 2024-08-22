//       Java
// Time complexity -  O(N)
// Space complexity - O(1)
class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // 2, 2, 1
        }
        return result;
    }
}