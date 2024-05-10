import java.util.ArrayList;
import java.util.List;

// Time complexity - O (N)
// Space complexity - O (N)
public class MyCalendarTwo {

    List<int[]> calendar;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] interval : overlaps) {
            if (start < interval[1] && end > interval[0]) {
                return false;
            }
        }

        for (int[] interval : calendar) {
            if (start < interval[1] && end > interval[0]) {
                overlaps.add(new int[]{Math.max(start, interval[0]), Math.min(end, interval[1])});
            }
        }

        calendar.add(new int[]{start, end});
        return true;
    }

}
