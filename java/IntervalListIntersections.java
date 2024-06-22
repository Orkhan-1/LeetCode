import java.util.ArrayList;
import java.util.List;

// Time complexity - O (N, M)
// Space complexity - O(min(N, M))
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int f = 0;
        int s = 0;
        List<int[]> result = new ArrayList<>();

        while (f < firstList.length && s < secondList.length) {
            int start = Math.max(firstList[f][0], secondList[s][0]);
            int end = Math.min(firstList[f][1], secondList[s][1]);

            if (start <= end) {
                result.add(new int[]{start, end});
            }

            if (end == firstList[f][1]) {
                f++;
            }

            if (end == secondList[s][1]) {
                s++;
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}
