import java.util.LinkedList;
import java.util.List;

public class MyHashSet {

    private static final int SET_SIZE = 16;
    List<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SET_SIZE];
    }

    public void add(int key) {
        int hashCode = hashCode(key);
        if (buckets[hashCode] == null) {
            buckets[hashCode] = new LinkedList<>();
        }
        if (!buckets[hashCode].contains(key)) {
            buckets[hashCode].add(key);
        }

    }

    public void remove(int key) {
        int hashCode = hashCode(key);
        if (buckets[hashCode] == null && buckets[hashCode].contains(key)) {
            buckets[hashCode].remove(key);
        }
    }

    public boolean contains(int key) {
        int hashCode = hashCode(key);
        return buckets[hashCode] != null && buckets[hashCode].contains(key);
    }

    private int hashCode(int key) {
        return key % SET_SIZE;
    }


}

class SetEntry<K> {
    public K key;

    public SetEntry(K key) {
        this.key = key;
    }
}