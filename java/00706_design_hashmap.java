// Time complexity - put, remove, get O(1) -> O(n)
// Space complexity - O(n)
class MyHashMap {

    private static final int SIZE = 1000;
    private Node[] map;

    private class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        map = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new Node(key, value);
        } else {
            Node current = map[index];
            while (true) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int index = hash(key);
        Node current = map[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node current = map[index];
        if (current == null) {
            return;
        }
        if (current.key == key) { // (3, 11) -> (5, 10) ==> (5, 10)
            map[index] = current.next;
            return;
        }

        Node prev = current; // (3, 11) -> (5, 10) -> (8->20) ==> (3, 11) -> (8->20)
        while (current != null) {
            if (current.key == key) {
                prev.next = current.next; // unlink the node
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
