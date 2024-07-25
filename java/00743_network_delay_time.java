import java.util.Arrays;

// Time complexity -  O (V*E)
// Space complexity - O (V)
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {

        int[] timeToTravel = new int[N + 1];
        Arrays.fill(timeToTravel, Integer.MAX_VALUE);
        timeToTravel[K] = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int[] edge : times) {
                int source = edge[0];
                int dest = edge[1];
                int time = edge[2];

                if (timeToTravel[source] != Integer.MAX_VALUE &&
                        timeToTravel[source] + time < timeToTravel[dest]) {
                    timeToTravel[dest] = timeToTravel[source] + time;
                }
            }
        }

        int maxTime = 0;

        for (int i = 1; i < timeToTravel.length; i++) {
            if (timeToTravel[i] > maxTime) {
                maxTime = timeToTravel[i];
            }
        }
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
}
