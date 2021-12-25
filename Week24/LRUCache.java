import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;
    private int currentCapacity;

    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    public int get(int key) {
        Node node = map.getOrDefault(key, null);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.getOrDefault(key, null) != null) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        } else {
            if (currentCapacity == capacity) {
                Node last = tail.prev;
                map.remove(last.key);
                Node left = last.prev;
                left.next = tail;
                tail.prev = left;
                currentCapacity--;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
            currentCapacity++;
        }
    }

    private void removeNode(Node node) {
        Node left = node.prev;
        Node right = node.next;
        left.next = right;
        right.prev = left;
    }

    private void addNode(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    private class Node {
        int value;
        int key;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.value = val;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }
}
