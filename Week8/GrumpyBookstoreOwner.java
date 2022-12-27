public class GrumpyBookstoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int result = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                result += customers[i];
            }
        }
        return result + maxWindow(customers, grumpy, X);
    }

    private int maxWindow(int[] customers, int[] grumpy, int X) {
        int max = 0;
        int index = 1;
        int total = 0;
        for (int i = 0; i < customers.length; i++, index++) {
            if (index > X && grumpy[i - X] == 1) {
                total -= customers[i - X];
            }
            if (grumpy[i] == 1) {
                total += customers[i];
            }
            max = Math.max(max, total);
        }
        return max;
    }
}
