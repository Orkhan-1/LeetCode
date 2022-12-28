import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0;
        int i = 0;
        int j = people.length - 1;
        while (i < j) {
            if (people[i] + people[j] > limit) {
                j--;
            } else {
                i++;
                j--;
            }
            result++;
        }
        if (i == j) {
            result++;
        }
        return result;
    }
}
