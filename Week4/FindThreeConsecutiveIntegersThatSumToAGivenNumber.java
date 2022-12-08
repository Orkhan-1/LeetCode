public class FindThreeConsecutiveIntegersThatSumToAGivenNumber {

    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[0];
        }
        long[] result = new long[3];
        long temp = num / 3;
        result[0] = temp - 1;
        result[1] = temp;
        result[2] = temp + 1;
        return result;
    }
}
