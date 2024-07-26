import java.util.TreeMap;

// Time complexity - O (logN)
// Space complexity - O (N)
public class MyCalendarOne {

    private TreeMap<Integer, Integer> calendar;

    public MyCalendarOne() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floorKey = calendar.floorKey(start);
        Integer ceilKey = calendar.ceilingKey(start);

        if ((floorKey == null || calendar.get(floorKey) <= start) &&
                (ceilKey == null || end <= ceilKey)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
