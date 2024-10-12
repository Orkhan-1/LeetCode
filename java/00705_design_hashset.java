// Time complexity - put, remove, get O(1) -> O(n)
// Space complexity - O(n)
public class MyHashSet {
    private static final int SIZE = 1000;
    private Node[] buckets;

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public MyHashSet() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int value) {
        int index = hash(value);
        if (buckets[index] == null) {
            buckets[index] = new Node(value);
        } else {
            Node current = buckets[index];
            if (current.value == value) {
                return;
            }
            while (current.next != null) {
                if (current.next.value == value) {
                    return;
                }
                current = current.next;
            }
            current.next = new Node(value);
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.value == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(int value) {
        int index = hash(value);
        if (buckets[index] == null) {
            return;
        }
        if (buckets[index].value == value) {  // 10 -> 5 ==> 5
            buckets[index] = buckets[index].next;
            return;
        }
        Node current = buckets[index];
        while (current.next != null) { // 10 -> 12 -> 18 ==> 10 -> 18
            if (current.next.value == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}