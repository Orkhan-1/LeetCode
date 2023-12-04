
// Time complexity -  O(log (Max [start, end])) -  length of the binary representation of a number is log(base N)
// Space complexity - O (1)
public class MinimumBitFlipsToConvertNumber {

    public int minBitFlips(int start, int goal) {
        int result = start ^ goal;
        int flips = 0;

        while (result != 0) {
            flips += result & 1;
            result >>= 1;
        }

        return flips;
    }
}
