// Time complexity -  O(N)
// Space complexity - O (1)

public class XOROperationInAnArray {

    //   A | B | A XOR B
//       --------------
    //       0 | 0 |    0
    //       0 | 1 |    1
    //       1 | 0 |    1
    //       1 | 1 |    0

    // 0 ^ 2 = 2
    // 2 ^ 4 = 6
    // 6 ^ 6 = 0
    // 0 ^ 8 = 0

    public int xorOperation(int n, int start) {
        int result = start;

        for (int i = 1; i < n; i++) {
            result ^= (start + 2 * i);
        }

        return result;
    }

}
