import java.util.*;

// Time complexity - O (1)
// Space complexity - O (N)bb
public class InsertDeleteGetRandom {

    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastValue = list.get(list.size() - 1);
        list.set(index, lastValue);
        map.put(lastValue, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
