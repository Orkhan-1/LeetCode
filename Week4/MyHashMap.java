import java.util.LinkedList;

class MyHashMap {

    LinkedList<Entry<Integer, Integer>>[] map;
    public static final int MAP_SIZE = 16;

    public MyHashMap() {
        map = new LinkedList[MAP_SIZE];
    }

    public void put(int key, int value) {
        int bucket = key % MAP_SIZE;
        if (map[bucket] == null) {
            map[bucket] = new LinkedList<>();
            map[bucket].add(new Entry<>(key, value));
        } else {
            for (Entry<Integer, Integer> entry : map[bucket]) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
            map[bucket].add(new Entry<>(key, value));
        }
    }

    public int get(int key) {
        int bucket = key % MAP_SIZE;
        LinkedList<Entry<Integer, Integer>> entries = map[bucket];
        if (entries == null) {
            return -1;
        }
        for (Entry<Integer, Integer> entry : entries) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = key % MAP_SIZE;
        Entry<Integer, Integer> remove = null;
        if (map[bucket] != null) {
            for (Entry<Integer, Integer> entry : map[bucket]) {
                if (entry.key == key) {
                    remove = entry;
                }
            }
            if (remove == null) {
                return;
            }
            map[bucket].remove(remove);
        }
    }
}

class Entry<K, V> {
    public K key;
    public V value;

    public Entry(K key, V val) {
        this.key = key;
        this.value = val;
    }
}